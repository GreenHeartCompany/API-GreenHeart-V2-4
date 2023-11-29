package api.service.publicacao;

import api.dto.publicacao.PublicacaoDto;
import api.domain.publicacao.Publicacao;
import api.repository.PublicacaoRepository;
import api.dto.publicacao.PublicacaoMapper;

import api.service.empresa.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PublicacaoServiceImpl implements PublicacaoService {
    private List<PublicacaoListener> ouvintes = new ArrayList<>();
    private String mensage = "";

    private final PublicacaoRepository publicacaoRepository;
    private final EmpresaService empresaService;

    @Autowired
    @Lazy
    public PublicacaoServiceImpl(PublicacaoRepository publicacaoRepository, EmpresaService empresaService) {
        this.publicacaoRepository = publicacaoRepository;
        this.empresaService = empresaService;
    }

    public Publicacao createPost(PublicacaoDto post) {
        //Empresa empresaBanco = empresaService.buscarPorId(post.getFkEmpresa()).orElseThrow(() -> new RuntimeException(String.format("Empresa com o ID %d não encontrado ", post.getFkEmpresa())));
        if (Objects.nonNull(post)) {
            var publicacaoMapper = PublicacaoMapper.of(post);
            publicacaoMapper.setEmpresa(empresaService.buscarPorId(post.getFkEmpresa()));
            Publicacao publicacao = publicacaoRepository.save(publicacaoMapper);
            ouvintes.forEach(ouvinte -> {
                try {
                    ouvinte.createPost(publicacao, post);
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            });
            return publicacao;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Publicação vázia.");
    }

    public List<Publicacao> listar() {
        return publicacaoRepository.findAll();
    }

    public Optional<Publicacao> atualizarPub(Long id, PublicacaoDto publicacaoAtualizada) {
        if (publicacaoRepository.existsById(id)) {
            publicacaoAtualizada.setId(id);
            return Optional.of(publicacaoRepository.save(PublicacaoMapper.of(publicacaoAtualizada)));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Publicação com ID: %d não encontrada.", id));
    }

    public void excluirPublicacao(Long id) {
        if (publicacaoRepository.existsById(id)) {
            publicacaoRepository.deleteById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Publicação com ID: %d não encontrada.", id));
    }

    public Optional<Object> buscarPublicacaoPorTitulo(String titulo) {
        return Optional.of(PublicacaoMapper.of(publicacaoRepository
                .findByTituloContainsIgnoreCase(titulo)));
    }

    @Override
    public Optional<Publicacao> buscarPorId(Long id) {
        if (publicacaoRepository.existsById(id)){
            return publicacaoRepository.findById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Publicação com ID: %d não encontrada.", id));
    }

    public void addPublicacaoListener(PublicacaoListener publicacaoListener) {
        ouvintes.add(publicacaoListener);
    }

    @Override
    public List<Publicacao> filtrar(String tipoPublicacao) {
        List<Publicacao> asd = publicacaoRepository.findAllByTipoAcaoEquals(tipoPublicacao);
        if (asd.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Nenhuma publicação encontrada.", tipoPublicacao));
        } else {
            return asd;
        }
    }
}
