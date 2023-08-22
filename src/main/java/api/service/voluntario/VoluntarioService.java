package api.service.voluntario;

import api.domain.voluntario.Voluntario;
import api.dto.voluntario.VoluntarioAtualizadoParcial;
import api.dto.voluntario.VoluntarioDto;
import api.dto.voluntario.VoluntarioListaDto;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface VoluntarioService {
    void cadastrar(@Valid VoluntarioDto voluntarioDto);
    List<VoluntarioListaDto> listar();
    List<VoluntarioDto> buscarPorCpf(String cpf);
    Optional<VoluntarioDto> atualizar(Long id, VoluntarioDto voluntarioAtualizado);
    void deletar(Long id);
    Optional<VoluntarioDto> atualizacaoParcial(Long id, VoluntarioAtualizadoParcial voluntarioAtualizado);
}
