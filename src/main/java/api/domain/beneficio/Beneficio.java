package api.domain.beneficio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import api.domain.publicacao.Publicacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Beneficio {
    private Boolean alimentacao;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_beneficio")
    @JsonIgnore
    private Long idBeneficio;
    private Boolean hospedagem;
    private  Boolean transporte;
    @ManyToOne
    @JoinColumn(name = "fk_publicacao")
    private Publicacao publicacao;
}
