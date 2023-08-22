package api.domain.voluntario;

import api.domain.usuario.Usuario;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("VOLUNTARIO")
public class Voluntario extends Usuario {
    private String cpf;
    @Column(name = "dt_nasc")
    private LocalDate dtNasc;
}
