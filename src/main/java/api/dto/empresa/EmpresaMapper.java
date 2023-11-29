package api.dto.empresa;

import api.domain.empresa.Empresa;
import api.domain.mask.Mascara;
import api.domain.plano.Plano;
import api.domain.usuario.Usuario;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static api.domain.mask.Mascara.*;

public class EmpresaMapper {
    public static Empresa of(@Valid EmpresaDto empresaRequest) {
        Empresa empresa = new Empresa();
        empresa.setIdUsuario(empresaRequest.getId());
        empresa.setNome(empresaRequest.getNome());
        empresa.setEmail(empresaRequest.getEmail());
        empresa.setSenha(empresaRequest.getSenha());
        empresa.setTelefone(clearTel(empresaRequest.getTelefone()));
        empresa.setCnpj(clearCnpj(empresaRequest.getCnpj()));
        return empresa;
    }

    public static EmpresaDto ConvertToDto(Usuario usuario) {
        EmpresaDto empresaDto = new EmpresaDto();
        empresaDto.setNome(usuario.getNome());
        empresaDto.setEmail(Mascara.maskEmail(usuario.getEmail()));
        empresaDto.setTelefone(Mascara.maskTelefone(formatTel(usuario.getTelefone())));
        empresaDto.setCnpj(Mascara.maskCnpj(formatCnpj(((Empresa) usuario).getCnpj())));
        return empresaDto;
    }

    public static List<EmpresaDto> of(List<Empresa> listaUsuarios) {
        return listaUsuarios.stream().map(EmpresaMapper::ConvertToDto).collect(Collectors.toList());
    }
}
