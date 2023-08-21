package api.dto.voluntario;

import api.dto.endereco.EnderecoDto;
import api.util.enums.TipoUsuarioEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoluntarioDto implements Comparable<VoluntarioDto>{
    @JsonIgnore
    private Long id;
    @NotBlank
    @Schema(name = "Nome", description = "", example = "Samuel Sena")
    private String nome;
    @NotBlank
    @Email
    @Schema(name = "Email", description = "", example = "samuelel@hotmail.com")
    private String email;
    @NotBlank
    @Size(min = 8)
    @Schema(name = "Senha", description = "", example = "@123jfnm19inmf")
    private String senha;
    @NotNull
    @JsonIgnore
    private TipoUsuarioEnum tipoUsuario = TipoUsuarioEnum.VOLUNTARIO;
    @NotBlank
    @Size(min = 11)
    @Pattern(regexp = "^(\\(?\\d{2}\\)?)?(\\d{4,5}\\-\\d{4})$",
            message = "Indique um telefone válido - Ex: (**)****-****")
    @Schema(name = "Telefone", description = "", example = "(11)96284-6349")
    private String telefone;
    @NotBlank
    @CPF
    @Size(min = 11)
    @Schema(name = "Cpf", description = "", example = "221.365.420-44")
    private String cpf;
    @NotNull
    @PastOrPresent
    @Schema(name = "Data de Nascimento", description = "", example = "2005-07-12")
    private LocalDate dtNasc;
    @NotNull
    private EnderecoDto endereco;

    @Override
    public String toString() {
        return "VoluntarioDto{" +
                "nome:" + nome +
                ", email: " + email +
                ", telefone: " + telefone +
                ", tipoUsuario: " + tipoUsuario +
                ", cpf: " + cpf +
                '}';
    }
    public int compareTo(VoluntarioDto voluntario) {
        return this.nome.compareTo(voluntario.nome);
    }

    public static <U, T> U getName(T t) {
        return getName(t);
    }
}
