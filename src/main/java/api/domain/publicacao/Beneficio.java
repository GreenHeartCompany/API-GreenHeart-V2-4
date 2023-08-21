package api.domain.publicacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Beneficio {

    private String isAlimentacao;

    private String isHospedagem;

    private String isTransporte;

}
