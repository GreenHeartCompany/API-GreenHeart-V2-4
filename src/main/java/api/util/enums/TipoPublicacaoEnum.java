package api.util.enums;

import lombok.Getter;

@Getter
public enum TipoPublicacaoEnum {
    PLANTACAO("Plantação"), RECICLAGEM("Reciclagem"), HORTA("Horta"), LIMPERA_RIO("Limpeza de rios");

    private final String tipoPublicacao;

    TipoPublicacaoEnum(String tipoPublicacao) { this.tipoPublicacao = tipoPublicacao; }
}
