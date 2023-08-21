package api.domain.plano;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Plano")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plano")
    private Long idPlano;
    @Column(name = "titulo_plano")
    private String tituloPlano;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "tempo_duracao")
    private Integer tempoDuracao;
    @Column(name = "valor")
    private Double valor;
}
