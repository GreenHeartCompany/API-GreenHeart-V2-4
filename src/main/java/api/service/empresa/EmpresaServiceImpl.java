package api.service.empresa;

import api.dto.empresa.EmpresaAtualizadaParcial;
import api.domain.empresa.Empresa;
import api.domain.endereco.Endereco;
import api.domain.usuario.Usuario;
import api.repository.EmpresaRepository;
import api.repository.EnderecoRepository;
import api.dto.empresa.EmpresaDto;
import api.dto.empresa.EmpresaMapper;
import api.dto.endereco.EnderecoMapper;
import api.service.usuario.UsuarioService;
import api.service.publicacao.PublicacaoService;
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
public class EmpresaServiceImpl implements EmpresaService {
    private final EmpresaRepository empresaRepository;
    private final EnderecoRepository enderecoRepository;
    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public EmpresaServiceImpl(EmpresaRepository empresaRepository, EnderecoRepository enderecoRepository,
                              UsuarioService usuarioService,
                              PublicacaoService publicacaoService, PasswordEncoder passwordEncoder) {
        this.empresaRepository = empresaRepository;
        this.enderecoRepository = enderecoRepository;
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    public void cadastrar(@Valid EmpresaDto novaEmpresa) {
        usuarioService.emailExiste(novaEmpresa.getEmail());
        Empresa empresa = EmpresaMapper.of(novaEmpresa);
        empresa.setSenha(passwordEncoder.encode(empresa.getSenha()));
        Usuario empresaBanco = empresaRepository.save(empresa);
        EmpresaDto empresaDto = EmpresaMapper.ConvertToDto(empresaBanco);
        empresaDto.getEndereco().setUsuario(empresaBanco);
        enderecoRepository.save(EnderecoMapper.to(empresaDto.getEndereco()));;
    }

    public List<Empresa> listar() {
        return empresaRepository.findAll();
        //lista.stream().map(EmpresaMapper::ConvertToDto).collect(Collectors.toList());
    }

    public List<EmpresaDto> buscarPorCnpj(String cnpj) {
        var empresaEncontrada = EmpresaMapper.of(empresaRepository.findAllByCnpj(cnpj));
        if (empresaEncontrada.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Nenhuma empresa encontrada com o CNPJ: %s", cnpj));
        }
        return EmpresaMapper.of(empresaRepository.findAllByCnpj(cnpj));
    }

    public Optional<EmpresaDto> atualizar(Long id, EmpresaDto empresaAtualizada) {
        if (empresaRepository.existsById(id)) {
            empresaAtualizada.setId(id);
            empresaAtualizada.setSenha(passwordEncoder.encode(empresaAtualizada.getSenha()));
            return Optional.of(EmpresaMapper.ConvertToDto(empresaRepository.save(EmpresaMapper.of(empresaAtualizada))));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Empresa com o ID %d não foi encontrada.", id));
    }

    public void deletar(Long id) {
        if (empresaRepository.existsById(id)) {
            empresaRepository.deleteById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Empresa com o ID %d inexistente.", id));
    }

    public Optional<EmpresaDto> atualizacaoParcial(Long id, EmpresaAtualizadaParcial empresaAtualizada) {
        if (empresaRepository.existsById(id)) {
            Optional<Empresa> empresaBanco = empresaRepository.findById(id);
            Endereco endereco = enderecoRepository.findByUsuarioEquals(id);

            if (empresaBanco.isPresent()) {
                Empresa obj = empresaBanco.get();
                if (!empresaAtualizada.getNome().isEmpty()) {
                    obj.setNome(empresaAtualizada.getNome());
                }

                if (!empresaAtualizada.getEmail().isEmpty()) {
                    obj.setEmail(empresaAtualizada.getEmail());
                }

                if (!empresaAtualizada.getSenha().isEmpty()) {
                    obj.setSenha(
                            passwordEncoder.encode(empresaAtualizada.getSenha()));
                }

                if (!empresaAtualizada.getTelefone().isEmpty()) {
                    obj.setTelefone(empresaAtualizada.getTelefone());
                }

                if (!empresaAtualizada.getCnpj().isEmpty()) {
                    obj.setCnpj(empresaAtualizada.getCnpj());
                }

                if (empresaAtualizada.getFkPlano() != null) {
                    obj.setFkPlano(empresaAtualizada.getFkPlano());
                }

                if (!empresaAtualizada.getEndereco().getLogradouro().isEmpty()) {
                    endereco.setLogradouro(empresaAtualizada.getEndereco().getLogradouro());
                }

                if (empresaAtualizada.getEndereco().getNumero() != null) {
                    endereco.setNumero(empresaAtualizada.getEndereco().getNumero());
                }

                if (!empresaAtualizada.getEndereco().getCep().isEmpty()) {
                    endereco.setCep(empresaAtualizada.getEndereco().getCep());
                }

                if (!empresaAtualizada.getEndereco().getComplemento().isEmpty()) {
                    endereco.setComplemento(empresaAtualizada.getEndereco().getComplemento());
                }

                enderecoRepository.save(endereco);
                empresaRepository.save(obj);

                return Optional.of(EmpresaMapper.ConvertToDto(obj));
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Empresa com o ID: %d não encontrado.", id));
    }

    @Override
    public Optional<Empresa> buscarPorId(Long id) {
        if (empresaRepository.existsById(id)) {
            return empresaRepository.findById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Empresa com o ID: %d não encontrado.", id));
    }
}
