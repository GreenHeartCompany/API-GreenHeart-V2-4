package api.service.voluntario;

import api.dto.voluntario.VoluntarioAtualizadoParcial;
import api.dto.voluntario.VoluntarioDto;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface VoluntarioService {
    VoluntarioDto cadastrar(@Valid VoluntarioDto voluntarioDto);
    List<VoluntarioDto> listar();
    List<VoluntarioDto> buscarPorCpf(String cpf);
    Optional<VoluntarioDto> atualizar(Long id, VoluntarioDto voluntarioAtualizado);
    void deletar(Long id);
    Optional<VoluntarioDto> atualizacaoParcial(Long id, VoluntarioAtualizadoParcial voluntarioAtualizado);
}
