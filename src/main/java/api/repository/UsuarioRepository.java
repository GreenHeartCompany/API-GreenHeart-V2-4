package api.repository;

import java.util.Optional;
import api.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    Boolean existsByEmailEquals(String email);
}
