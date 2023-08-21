package api.dto.voluntario;

import api.dto.endereco.EnderecoDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
public class VoluntarioAtualizadoParcial {
    private Long id;
    private String nome;
    @Email
    private String email;
    @Size(min = 8)
    private String senha;
    @Pattern(regexp = "^(\\(?\\d{2}\\)?)?(\\d{4,5}\\-\\d{4})$",
            message = "Indique um telefone válido - Ex: (**)****-****")
    private String telefone;
    @CPF
    private String cpf;
    @PastOrPresent
    private LocalDate dtNasc;
    private EnderecoDto endereco;
}
