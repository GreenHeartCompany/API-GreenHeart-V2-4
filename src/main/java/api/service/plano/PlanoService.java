package api.service.plano;

import api.dto.plano.PlanoDto;
import api.domain.plano.Plano;

import java.util.List;
import java.util.Optional;

public interface PlanoService {
    Plano criar(PlanoDto planoRequest);
    Optional<Plano> buscarPlanoPorId(Long id);
    List<Plano> listar();
    Void deletar(Long id);
}