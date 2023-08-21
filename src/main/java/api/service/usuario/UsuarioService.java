package api.service.usuario;

import api.domain.usuario.Usuario;
import api.repository.UsuarioRepository;
import api.dto.usuario.UsuarioCriacaoDto;
import api.dto.usuario.UsuarioLoginDto;
import api.dto.usuario.UsuarioMapper;
import api.dto.usuario.UsuarioTokenDto;
import api.controllers.configuration.jwt.GerenciadorTokenJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final GerenciadorTokenJwt gerenciadorTokenJwt;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, GerenciadorTokenJwt gerenciadorTokenJwt, AuthenticationManager authenticationManager) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.gerenciadorTokenJwt = gerenciadorTokenJwt;
        this.authenticationManager = authenticationManager;
    }

    public void criar(UsuarioCriacaoDto usuarioCriacaoDto) {
        final Usuario novoUsuario = UsuarioMapper.of(usuarioCriacaoDto);
        String senhaCriptografada = passwordEncoder.encode(novoUsuario.getSenha());
        novoUsuario.setSenha(senhaCriptografada);
        this.usuarioRepository.save(novoUsuario);
    }

    public UsuarioTokenDto autenticar(UsuarioLoginDto usuarioLoginDto){
        final UsernamePasswordAuthenticationToken credential =
                new UsernamePasswordAuthenticationToken(usuarioLoginDto.getEmail(), usuarioLoginDto.getSenha());

        final Authentication authentication = this.authenticationManager.authenticate(credential);

        Usuario usuarioAutenticado = usuarioRepository.findByEmail(usuarioLoginDto.getEmail())
                .orElseThrow(
                        () -> new ResponseStatusException(404, "Email do usuário não cadastrado", null)
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = gerenciadorTokenJwt.generateToken(authentication);

        return UsuarioMapper.of(usuarioAutenticado,token);
    }
    
    public Boolean emailExiste(String email) {
        if (usuarioRepository.existsByEmailEquals(email)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já existente.");
        return false;
    }

    // Configuração de autorização
    @Autowired
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Configuração de outras regras de segurança
                .logout()
                .logoutUrl("/logout") // URL para o endpoint de logout
                .logoutSuccessUrl("/login?logout") // URL de redirecionamento após o logout
                .invalidateHttpSession(true) // Invalida a sessão do usuário
                .deleteCookies("JSESSIONID")
                .permitAll();
                // Remove os cookies relacionados à sessão

    }
}
