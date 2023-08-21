package api.repository;

import api.domain.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    List<Empresa> findAll();
    List<Empresa> findAllByCnpj(String cnpj);
}
