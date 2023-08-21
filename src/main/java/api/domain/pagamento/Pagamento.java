package api.domain.pagamento;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Pagamento {
    private String token;
    private String issuer_id;
    private String payment_method_id;
    private BigDecimal transaction_amount;
    private int installments;
    private Pagador payer;
}
