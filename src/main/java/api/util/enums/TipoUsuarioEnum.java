package api.util.enums;

public enum TipoUsuarioEnum {
    VOLUNTARIO("Voluntário"), EMPRESA("Empresa");

    private final String tipoUsuario;

    TipoUsuarioEnum(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }
}
