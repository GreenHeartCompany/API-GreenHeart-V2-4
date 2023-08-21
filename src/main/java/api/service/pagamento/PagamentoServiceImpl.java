package api.service.pagamento;

import api.domain.pagamento.Pagamento;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.resources.payment.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PagamentoServiceImpl implements PagamentoService {

//    @Value("${mercadopago.token}")
    private String accessToken;

    @Override
    public Payment realizarPagamento(Pagamento request) {

        MercadoPagoConfig.setAccessToken(accessToken);

        PaymentClient client = new PaymentClient();

        try{
            PaymentCreateRequest paymentCreateRequest =
                    PaymentCreateRequest.builder()
                            .transactionAmount(request.getTransaction_amount())
                            .token(request.getToken())
                            .installments(request.getInstallments())
                            .paymentMethodId(request.getPayment_method_id())
                            .payer(
                                    PaymentPayerRequest.builder()
                                            .email(request.getPayer().getEmail())
                                            .identification(
                                                    IdentificationRequest.builder()
                                                            .type(request.getPayer().getIdentification().getType())
                                                            .number(request.getPayer().getIdentification().getNumber())
                                                            .build())
                                            .build())
                            .build();

            return client.create(paymentCreateRequest);
        } catch (Exception erro){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, erro.getMessage(), erro);
        }
    }
}
