package api.domain.arquivo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArquivoTxt {

    private String titulo;
    private String descricao;
    private String tipoAcao;
    private String totalHrTrabalho;
    private String nomeOrganizador;
    private String emailOrganizador;
    private String telOrganizador;
    private LocalDate dataHora;
    private String isTransporte;
    private String isHospedagem;
    private String isAlimentacao;

    @Override
    public String toString() {
        return "ArquivoTxt{" +
                "titulo='" + titulo + '\'' +
                ", tipoAcao='" + tipoAcao + '\'' +
                ", totalHrTrabalho='" + totalHrTrabalho + '\'' +
                ", nomeOrganizador='" + nomeOrganizador + '\'' +
                ", emailOrganizador='" + emailOrganizador + '\'' +
                ", telOrganizador='" + telOrganizador + '\'' +
                ", data=" + dataHora +
                ", isTransporte='" + isTransporte + '\'' +
                ", isHospedagem='" + isHospedagem + '\'' +
                ", isAlimentacao='" + isAlimentacao + '\'' +
                '}';
    }
}

