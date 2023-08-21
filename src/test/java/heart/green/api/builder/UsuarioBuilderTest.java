package heart.green.api.builder;

import api.domain.plano.Plano;
import api.dto.empresa.EmpresaDto;
import api.dto.voluntario.VoluntarioDto;
import api.domain.empresa.Empresa;
import api.util.enums.TipoUsuarioEnum;

import java.util.List;

public class UsuarioBuilderTest {
    private UsuarioBuilderTest() {
        throw new IllegalStateException("Classe Utilitária");
    }

    public static EmpresaDto empresa() {
        EmpresaDto empresa = new EmpresaDto();

        return empresa;
    }

    public static Empresa toUserModel() {
        return new Empresa();
    }

    public static List<Empresa> toEmpresaModelList() {
        EmpresaDto userAlternative = empresa();
        userAlternative.setId(2L);

        return List.of(toUserModel());
    }

    public static VoluntarioDto pesquisaVoluntario() {

        VoluntarioDto voluntarioDto = new VoluntarioDto(1L, "Samuel Sena", "samuelsenna21.09@gmail.com", TipoUsuarioEnum.VOLUNTARIO,
                "(11)95489-6439", "523.901.544.22");

        return voluntarioDto;
    }

    public static EmpresaDto listarEmpresaDto() {

        final EmpresaDto empresaDto = new EmpresaDto(1L, "Green Peace", "gregan@greenpeace.org", "(11)3845-1938",
                "23-157-361/0001-98", new Plano());
        return empresaDto;
    }

    public static VoluntarioDto criarVoluntarioDto() {

        final VoluntarioDto voluntarioDto = new VoluntarioDto(1L, "Samuel Sena", "samuelsenna21.09@gmail.com", TipoUsuarioEnum.VOLUNTARIO, "(11)95489-6439", "523.901.544.22");
        return voluntarioDto;
    }

    public static List<VoluntarioDto> criarListaDeVoluntatioDto() {
        return List.of(
                new VoluntarioDto(1L, "Samuel Sena", "samuel@gmail.com", TipoUsuarioEnum.VOLUNTARIO,
                        "(11)95489-6439", "526736554666"),

                        new VoluntarioDto(2L, "Andrey Rodrigues", "andrey@icloud.com", TipoUsuarioEnum.VOLUNTARIO,
                                "(11)91111-1111", "671882738299"),

                        new VoluntarioDto(3L, "Matheus Nascimentro", "matheus@outlook.com", TipoUsuarioEnum.VOLUNTARIO,
                                "(11)92222-2222", "82773882788")
        );
    }

    public static List<EmpresaDto> criarListaDeEmpresaDto() {
        return List.of(
                new EmpresaDto(1L, "Green Peace", "gregan@greenpeace.org", "(11)3845-1938",
                        "23-157-361/0001-98", new Plano()),

                new EmpresaDto(2L, "Cidade Sem Fome", "cidadesemfome@email.org", "(11)3845-1938",
                        "21-127-261/0001-22", new Plano()),

                new EmpresaDto(3L, "Verdejando", "Verdejando@globo.com", "(11)3845-1938",
                        "41-567-212/0003-12", new Plano())
        );
    }
}
