package api.dto.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsuarioLoginDto {
    @Schema(name = "Email", description = "", example = "samuel@email.com")
    private String email;
    @Schema(name = "Senha", description = "", example = "@123456789")
    private String senha;
}
