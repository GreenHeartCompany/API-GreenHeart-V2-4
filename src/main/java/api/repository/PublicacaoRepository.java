package api.repository;

import api.dto.publicacao.PublicacaoDto;
import api.domain.publicacao.Publicacao;
import api.util.enums.TipoPublicacaoEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {
    PublicacaoDto findByTituloContainsIgnoreCase(String titulo);
    List<Publicacao> findAllByTipoAcaoEquals(String tipo);
}
