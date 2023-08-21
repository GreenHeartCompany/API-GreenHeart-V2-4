package api.domain.pagamento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagador {
    private String email;
    private Identificacao identification;
}
