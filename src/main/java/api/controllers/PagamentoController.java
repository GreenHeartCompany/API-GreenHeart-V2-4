package api.controllers;

import com.mercadopago.resources.payment.Payment;
import api.domain.pagamento.Pagamento;
import api.service.pagamento.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/processar")
    @CrossOrigin(origins = "http://localhost:3000/processar-pagamento")
    public ResponseEntity<Payment> pagar(@RequestBody Pagamento payment) {
        return ResponseEntity.ok(pagamentoService.realizarPagamento(payment));
    }
}