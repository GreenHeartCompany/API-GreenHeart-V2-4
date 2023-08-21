package api.domain.empresa;

import api.domain.plano.Plano;
import api.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("EMPRESA")
public class Empresa extends Usuario {
    @Column(name = "cnpj")
    private String cnpj;
    @ManyToOne
    @JoinColumn(name = "fk_plano")
    @JsonIgnore
    private Plano fkPlano;
}
