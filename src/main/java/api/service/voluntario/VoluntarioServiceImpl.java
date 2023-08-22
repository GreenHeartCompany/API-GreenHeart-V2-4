package api.service.voluntario;

import api.dto.voluntario.VoluntarioAtualizadoParcial;
import api.domain.endereco.Endereco;
import api.domain.usuario.Usuario;
import api.domain.voluntario.Voluntario;
import api.dto.voluntario.VoluntarioDto;
import api.dto.voluntario.VoluntarioListaDto;
import api.repository.EnderecoRepository;
import api.repository.VoluntarioRepository;
import api.dto.endereco.EnderecoMapper;
import api.dto.voluntario.VoluntarioMapper;
import api.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VoluntarioServiceImpl implements VoluntarioService {
    private final VoluntarioRepository voluntarioRepository;
    private final EnderecoRepository enderecoRepository;
    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public VoluntarioServiceImpl(VoluntarioRepository voluntarioRepository, EnderecoRepository enderecoRepository, UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.voluntarioRepository = voluntarioRepository;
        this.enderecoRepository = enderecoRepository;
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    public void cadastrar(@Valid VoluntarioDto voluntarioRequest) {
        usuarioService.emailExiste(voluntarioRequest.getEmail());
        Voluntario voluntario = VoluntarioMapper.of(voluntarioRequest);
        voluntario.setSenha(passwordEncoder.encode(voluntario.getSenha()));
        Usuario voluntarioBanco = voluntarioRepository.save(voluntario);
        voluntarioRequest.getEndereco().setUsuario(voluntarioBanco);
        enderecoRepository.save(EnderecoMapper.to(voluntarioRequest.getEndereco()));
    }

    public List<VoluntarioListaDto> listar() {
        List<Voluntario> listaVoluntarios = voluntarioRepository.findAll();
        if (listaVoluntarios.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return listaVoluntarios.stream().map(VoluntarioMapper::ConvertListToDto).collect(Collectors.toList());
    }

    public List<VoluntarioDto> listarTst() {
        List<Voluntario> listaVoluntario = voluntarioRepository.findAll();
        return listaVoluntario.stream().map(VoluntarioMapper::ConvertToDto).collect(Collectors.toList());
    }

    public List<VoluntarioDto> buscarPorCpf(String cpf) {
        List<Voluntario> voluntario = voluntarioRepository.findAllByCpf(cpf);
        if (voluntario.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Voluntário com o CPF: %s não encontrado.", cpf));
        return VoluntarioMapper.of(voluntario);
    }

    public Optional<VoluntarioDto> atualizar(Long id, VoluntarioDto voluntarioAtualizado) {
        if (voluntarioRepository.existsById(id)) {
            voluntarioAtualizado.setId(id);
            voluntarioAtualizado.setSenha(passwordEncoder.encode(voluntarioAtualizado.getSenha()));
            return Optional.of(VoluntarioMapper.ConvertToDto(voluntarioRepository.save(VoluntarioMapper.of(voluntarioAtualizado))));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Voluntário com o ID: %d não encontrado.", id));
    }

    public void deletar(Long id) {
        if (voluntarioRepository.existsById(id)) {
            voluntarioRepository.deleteById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Voluntário com o ID: %d não encontrado.", id));
    }

    public Optional<VoluntarioDto> atualizacaoParcial(Long id, VoluntarioAtualizadoParcial voluntarioAtualizado) {
        if (voluntarioRepository.existsById(id)) {
            Optional<Voluntario> voluntarioBanco = voluntarioRepository.findById(id);
            Endereco endereco = enderecoRepository.findByUsuarioEquals(id);

            if (voluntarioBanco.isPresent()){
                Voluntario obj = voluntarioBanco.get();
                if (!voluntarioAtualizado.getNome().isEmpty()) {
                    obj.setNome(voluntarioAtualizado.getNome());
                }

                if (!voluntarioAtualizado.getEmail().isEmpty()) {
                    obj.setEmail(voluntarioAtualizado.getEmail());
                }

                if (!voluntarioAtualizado.getSenha().isEmpty()) {
                    obj.setSenha(
                            passwordEncoder.encode(voluntarioAtualizado.getSenha()));
                }

                if (!voluntarioAtualizado.getTelefone().isEmpty()) {
                    obj.setTelefone(voluntarioAtualizado.getTelefone());
                }

                if (!voluntarioAtualizado.getCpf().isEmpty()) {
                    obj.setCpf(voluntarioAtualizado.getCpf());
                }

                if (voluntarioAtualizado.getDtNasc() != null) {
                    obj.setDtNasc(voluntarioAtualizado.getDtNasc());
                }

                if (!voluntarioAtualizado.getEndereco().getLogradouro().isEmpty()) {
                    endereco.setLogradouro(voluntarioAtualizado.getEndereco().getLogradouro());
                }

                if (voluntarioAtualizado.getEndereco().getNumero() != null) {
                    endereco.setNumero(voluntarioAtualizado.getEndereco().getNumero());
                }

                if (!voluntarioAtualizado.getEndereco().getCep().isEmpty()) {
                    endereco.setCep(voluntarioAtualizado.getEndereco().getCep());
                }

                if (!voluntarioAtualizado.getEndereco().getComplemento().isEmpty()) {
                    endereco.setComplemento(voluntarioAtualizado.getEndereco().getComplemento());
                }

                enderecoRepository.save(endereco);
                voluntarioRepository.save(obj);

                return Optional.of(VoluntarioMapper.ConvertToDto(obj));
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Voluntário com o ID: %d não encontrado.", id));
    }
}
