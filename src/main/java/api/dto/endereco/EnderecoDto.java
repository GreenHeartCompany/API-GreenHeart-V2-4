package api.dto.endereco;

import api.domain.usuario.Usuario;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class EnderecoDto {
    @NotBlank
    @Column(name = "logradouro")
    @Schema(name = "logradouro", description = "Nome da rua/avenida", example = "Avenida Duque de Caxias")
    private String logradouro;
    @NotBlank
    @Pattern(regexp = "^\\d{2}\\d{3}[-]\\d{3}$", message = "O CEP deve corresponder ao formato: *****-***")
    @Column(name = "cep")
    @Schema(name = "cep", description = "", example = "69961-183")
    private String cep;
    @NotNull
    @Column(name = "numero")
    @Schema(name = "numero", description = "", example = "2738")
    private Integer numero;
    @Column(name = "complemento")
    @Schema(name = "complemento", description = "Refêrencias para encontrar local", example = "Cobertura 9")
    private String complemento;
    @NotNull
    private Usuario usuario;
}
