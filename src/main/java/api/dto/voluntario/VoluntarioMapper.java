package api.dto.voluntario;

import api.domain.mask.Mascara;
import api.domain.usuario.Usuario;
import api.domain.voluntario.Voluntario;

import java.util.List;
import java.util.stream.Collectors;

public class VoluntarioMapper {
    public static Voluntario of(VoluntarioDto voluntarioDto) {
        Voluntario voluntario = new Voluntario();
        voluntario.setIdUsuario(voluntarioDto.getId());
        voluntario.setNome(voluntarioDto.getNome());
        voluntario.setEmail(voluntarioDto.getEmail());
        voluntario.setSenha(voluntarioDto.getSenha());
        voluntario.setTelefone(Mascara.clearTel(voluntarioDto.getTelefone()));
        voluntario.setCpf(Mascara.clearCpf(voluntarioDto.getCpf()));
        voluntario.setDtNasc(voluntarioDto.getDtNasc());
        return voluntario;
    }

    public static api.dto.voluntario.VoluntarioDto ConvertToDto(Usuario usuario) {
        api.dto.voluntario.VoluntarioDto voluntarioDto = new api.dto.voluntario.VoluntarioDto();
        voluntarioDto.setNome(usuario.getNome());
        voluntarioDto.setEmail(Mascara.maskEmail(usuario.getEmail()));
        voluntarioDto.setTelefone(Mascara.maskTelefone(Mascara.formatTel(usuario.getTelefone())));
        voluntarioDto.setCpf(Mascara.maskCpf(Mascara.formatCpf(((Voluntario)usuario).getCpf())));
        return voluntarioDto;
    }

    public static List<api.dto.voluntario.VoluntarioDto> of(List<Voluntario> listaUsuarios) {
        return listaUsuarios.stream().map(VoluntarioMapper::ConvertToDto).collect(Collectors.toList());
    }
}
