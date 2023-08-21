package api.controllers.configuration.security;

import api.service.usuario.autenticacao.AutenticacaoService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AutenticacaoProvider implements AuthenticationProvider {

    private final AutenticacaoService usuarioAutorizadoService;
    private final PasswordEncoder passwordEncoder;

    public AutenticacaoProvider(AutenticacaoService usuarioAutorizadoService, PasswordEncoder passwordEncoder) {
        this.usuarioAutorizadoService = usuarioAutorizadoService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String userName = authentication.getName();
        final String password = authentication.getCredentials().toString();

        UserDetails userDetails = this.usuarioAutorizadoService.loadUserByUsername(userName);

        if(this.passwordEncoder.matches(password, userDetails.getPassword())){
            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        }else{
            throw new BadCredentialsException("Usuário ou senha inválidos");
        }
    }

    @Override
    public boolean supports(final Class<?> authetication){
        return authetication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
