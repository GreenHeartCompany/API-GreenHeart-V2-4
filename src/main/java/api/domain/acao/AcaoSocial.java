package api.domain.acao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class AcaoSocial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_acao_social")
    private Long id;
    private LocalDateTime dataHora;
}
