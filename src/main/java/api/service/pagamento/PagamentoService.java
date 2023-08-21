package api.service.pagamento;

import api.domain.pagamento.Pagamento;
import com.mercadopago.resources.payment.Payment;

public interface PagamentoService {
    Payment realizarPagamento(Pagamento payment);
}
