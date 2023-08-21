package api.dto.beneficio;

import api.domain.publicacao.Publicacao;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BeneficioDto {
    private Boolean alimentacao;
    private Boolean hospedagem;
    private Boolean transporte;
    private Publicacao publicacao;
}
