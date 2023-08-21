package api.dto.empresa;

import api.domain.plano.Plano;
import api.dto.endereco.EnderecoDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.*;

@Getter
@Setter
public class EmpresaAtualizadaParcial {
    private Long id;
    private String nome;
    @Email
    private String email;
    @Size(min = 8)
    private String senha;
    @Pattern(regexp = "^(\\(?\\d{2}\\)?)?(\\d{4,5}\\-\\d{4})$",
            message = "Indique um telefone válido - Ex: (**)****-****")
    private String telefone;
    @CNPJ
    private String cnpj;
    private Plano fkPlano;
    private EnderecoDto endereco;
}
