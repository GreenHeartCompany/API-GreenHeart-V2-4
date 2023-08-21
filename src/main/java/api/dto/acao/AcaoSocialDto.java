package api.dto.acao;

import api.domain.empresa.Empresa;
import api.domain.endereco.Endereco;
import api.domain.usuario.Usuario;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Getter
@Setter
public class AcaoSocialDto {
    @NotNull
    @Schema(name = "dataHora", description = "", example = "2022/05/26 15:07:00")
    private LocalDateTime dataHora;
    @NotNull
    @Schema(name = "usuario", description = "", example = "")
    private Usuario usuario;
    @NotNull
    @Schema(name = "empresa", description = "", example = "")
    private Empresa empresa;
    @NotNull
    @Schema(name = "endereco", description = "", example = "")
    private Endereco endereco;
}
