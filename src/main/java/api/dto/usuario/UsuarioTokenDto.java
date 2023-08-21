package api.dto.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsuarioTokenDto {
    @Schema(name = "nome", description = "", example = "Samuel Sena")
    private String nome;
    @Schema(name = "email", description = "", example = "samuel@email.com")
    private String email;
    @Schema(name = "tipoUsuario", description = "", example = "VOLUNTÁRIO")
    private String tipoUsuario;
    @Schema(name = "token", description = "Chave Aleatória", example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYXRhYXQub2x2QGVtYWlsLmNvbSIsImlhdCI6MTY4MTk2MDA1NCwiZX...")
    private String token;
}
