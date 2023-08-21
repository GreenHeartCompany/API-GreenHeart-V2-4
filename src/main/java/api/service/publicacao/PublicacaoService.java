package api.service.publicacao;

import api.dto.publicacao.PublicacaoDto;
import api.domain.publicacao.Publicacao;

import java.util.List;
import java.util.Optional;

public interface PublicacaoService {
    Publicacao createPost(PublicacaoDto post);
    List<Publicacao> listar();
    Optional<Publicacao> atualizarPub(Long id, PublicacaoDto publicacaoAtualizada);
    void excluirPublicacao(Long id);
    Optional<Publicacao> buscarPorId(Long id);
    void addPublicacaoListener(PublicacaoListener publicacaoListener);
}

