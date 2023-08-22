package api.service.empresa;

import api.dto.empresa.EmpresaAtualizadaParcial;
import api.domain.empresa.Empresa;
import api.dto.empresa.EmpresaDto;

import java.util.List;
import java.util.Optional;

public interface EmpresaService{
    void cadastrar( EmpresaDto empresaRequest) throws Exception;
    List<Empresa> listar();
    List<EmpresaDto> buscarPorCnpj(String cnpj);
    Optional<EmpresaDto> atualizar(Long id, EmpresaDto empresaAtualizada);
    void deletar(Long id);
    Optional<EmpresaDto> atualizacaoParcial(Long id, EmpresaAtualizadaParcial empresaAtualizada);
    Optional<Empresa> buscarPorId(Long id);
}
