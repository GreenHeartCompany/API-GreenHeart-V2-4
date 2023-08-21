package api.repository;

import api.domain.voluntario.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {
    List<Voluntario> findAll();
    List<Voluntario> findAllByCpf(String cpf);
}
