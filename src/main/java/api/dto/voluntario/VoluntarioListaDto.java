package api.dto.voluntario;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VoluntarioListaDto {
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private LocalDate dtNasc;
}
