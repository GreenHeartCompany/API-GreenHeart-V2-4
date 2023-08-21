package api.util.enums;

public enum PlanoEmpresaEnum {
    BASIC("Básico Girassol"), MEDIUM("Intermediário Lírio"), PREMIUM("Premium Cosmos");

    private final String tipoPlano;

    PlanoEmpresaEnum(String tipoPlano) {
        this.tipoPlano = tipoPlano;
    }
}
