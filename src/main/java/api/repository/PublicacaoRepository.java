package api.repository;

import api.dto.publicacao.PublicacaoDto;
import api.domain.publicacao.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {
    PublicacaoDto findByTituloContainsIgnoreCase(String titulo);
}
