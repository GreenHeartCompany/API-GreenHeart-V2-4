package api.dto.empresa;

import api.dto.endereco.EnderecoDto;
import api.util.enums.TipoUsuarioEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import api.domain.plano.Plano;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDto implements Comparable<EmpresaDto>{
    @JsonIgnore
    private Long id;
    @NotBlank
    @Schema(name = "nome", description = "Razão Social", example = "Green Peace")
    private String nome;
    @NotBlank
    @Email
    @Schema(name = "email", description = "", example = "relacionamento@greenpeace.org")
    private String email;
    @NotBlank
    @Size(min = 8)
    @Schema(name = "senha", description = "", example = "@green348002!")
    private String senha;
    @NotNull
    @JsonIgnore
    private TipoUsuarioEnum tipoUsuario = TipoUsuarioEnum.EMPRESA;
    @NotBlank
    @Pattern(regexp = "^(\\(?\\d{2}\\)?)?(\\d{4,5}\\-\\d{4})$",
            message = "Indique um telefone válido - Ex: (**)****-****")
    @Schema(name = "telefone", description = "", example = "(11)5065-2938")
    private String telefone;
    @NotBlank
    @CNPJ
    @Schema(name = "cnpj", description = "", example = "23.166.291/0001-98")
    private String cnpj;
    @NotNull
    private EnderecoDto endereco;
    @NotNull
    @Schema(name = "plano", description = "Plano contratado", example = "BASIC")
    private Plano fkPlano;
    @JsonIgnore
    private Boolean isPlanoAtivo = false;
    @Override
    public int compareTo(EmpresaDto o) {
        return 0;
    }
}
