package api.dto.publicacao;

import api.domain.empresa.Empresa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.sql.Time;

@Getter
@Setter
public class PublicacaoDto {
    @JsonIgnore
    private Long id;
    @NotBlank
    @Schema(name = "titulo", description = "Titulo da publicação", example = "Ação de coleta no Parque")
    private String titulo;
    @NotBlank
    @Schema(name = "descrição", description = "", example = "Infomações e intuito da ação")
    @Size (min = 3)
    private String descricao;
    @NotBlank
    @Schema(name = "TipoAcao", description = "Acão em que o voluntario irá atuar", example = "Reciclagem")
    private String tipoAcao;
    @NotNull
    @Schema(name = "totalHrTrabalhada", description = "", example = "04:00")
    private Time totalHrTrabalho;
    @NotBlank
    @Schema(name = "nomeOrganizador", description = "", example = "Hans Dieter")
    private String nomeOrganizador;
    @NotBlank
    @Email
    @Schema(name = "emailOrganizador", description = "", example = "hansdieter.csf@gmail.com")
    private String emailOrganizador;
    @NotBlank
    @Pattern(regexp = "^(\\(?\\d{2}\\)?)?(\\d{4,5}\\-\\d{4})$",
            message = "Indique um telefone válido - Ex: ()**-**")
    @Schema(name = "telOrganizador", description = "", example = "(11) 95489-6439")
    private String telOrganizador;
    @NotNull
    @Schema(name = "fk_empresa", description = "", example = "")
    private Empresa fkEmpresa;
}
