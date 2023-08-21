package api.dto.plano;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PlanoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    public Long idPlano;
    @NotBlank
    @Schema(name = "tituloPlano", description = "", example = "Lírio")
    public String tituloPlano;
    @NotBlank
    @Schema(name = "descricao", description = "", example = "Plano intermediário que " +
            "permite fazer 15 publicações mensais promovendo ações sociais")
    public String descricao;
    @Schema(name = "tempoDuracao", description = "Tempo de duração do plano.", example = "4")
    public Integer tempoDuracao;
    @NotNull
    @Schema(name = "valor", description = "", example = "105.98")
    public Double valor;
}
