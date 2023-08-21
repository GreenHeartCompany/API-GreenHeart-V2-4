package api.dto.usuario;

import api.util.enums.TipoUsuarioEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(allOf = {})
public class UsuarioCriacaoDto {
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private TipoUsuarioEnum tipoUsuario;
}
