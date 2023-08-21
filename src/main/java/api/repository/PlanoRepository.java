package api.repository;

import api.domain.plano.Plano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanoRepository extends JpaRepository<Plano, Long>{
}
