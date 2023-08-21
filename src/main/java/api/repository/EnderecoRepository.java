package api.repository;

import api.domain.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Endereco findByUsuarioEquals(Long id);
}
