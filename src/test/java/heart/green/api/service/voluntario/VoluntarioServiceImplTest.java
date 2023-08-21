package heart.green.api.service.voluntario;

import api.service.voluntario.VoluntarioServiceImpl;
import heart.green.api.builder.UsuarioBuilderTest;
import api.dto.voluntario.VoluntarioDto;
import api.util.enums.TipoUsuarioEnum;
import api.repository.VoluntarioRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VoluntarioServiceImplTest {
    @Mock
    private VoluntarioRepository voluntarioRepository;
    @InjectMocks
    private VoluntarioServiceImpl voluntarioService;
    private VoluntarioDto voluntarioDto;

    @Test
    @DisplayName("Listar quando acionado deve retornar itens")
    void listarQuandoAcionadoDeveRetornarObjetosValidos(){
       Integer resultadoEsperado = 3;
        List<VoluntarioDto> voluntario = UsuarioBuilderTest.criarListaDeVoluntatioDto();
        assertEquals(resultadoEsperado, voluntario.size());
    }

    @Test
    @DisplayName("Listar quando acionado deve retornar lista vazia")
    void listarQuandoAcionadoRetornarListaPubliVazia(){
       Integer resultadoEsperado = 0;
       Mockito.when(voluntarioRepository.findAll()).thenReturn(List.of());
       List<VoluntarioDto> resultado = voluntarioService.listarTst();
       assertTrue(resultado.isEmpty());
       assertEquals(resultadoEsperado, resultado.size());
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar nome")
    void retornarQuandoAcionadoDeveRetornaNome(){
        String nomeEsperado = "Samuel Sena";
        String user = UsuarioBuilderTest.pesquisaVoluntario().getNome();
        assertEquals(nomeEsperado, user);
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar nome invalido")
    void retornarQuandoAcionadoDeveRetornaNomeInvalido(){
        String nomeEsperado = "Samuel Sena";
        String nomeInvalido = "";
        String nomeInvalido2 = "12345678";
        String nomeInvalido3 = "{})(&@$%!@#";
        String user = UsuarioBuilderTest.pesquisaVoluntario().getNome();
        assertEquals(nomeEsperado, user);
        assertNotEquals(nomeInvalido, user);
        assertNotEquals(nomeInvalido2, user);
        assertNotEquals(nomeInvalido3, user);
    }

    @Test
    @DisplayName("Retornar excecao quando nome for null")
    void retornarExcecaoQuandoAcionadoNomeERetornarNull(){
        HttpStatus nomeEsperado = null;
        List<VoluntarioDto> user = voluntarioService.listarTst();
        assertTrue(user.isEmpty());
        assertEquals(nomeEsperado, voluntarioDto);
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar email")
    void retornarQuandoAcionadoDeveRetornaEmail(){
        String emailEsperado = "samuelsenna21.09@gmail.com";
        String user = UsuarioBuilderTest.pesquisaVoluntario().getEmail();
        assertEquals(emailEsperado, user);
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar email invalido")
    void retornarQuandoAcionadoDeveRetornaEmailInvalido(){
        String emailEsperado = "samuelsenna21.09@gmail.com";
        String emailInvalido = "samuelsenna21.09email.com";
        String emailInvalido2 = "samuelsenna21.09@email";
        String emailInvalido3 = "samuelsenna21.09";
        String emailInvalido4 = "";
        String user = UsuarioBuilderTest.pesquisaVoluntario().getEmail();
        assertEquals(emailEsperado, user);
        assertNotEquals(emailInvalido, user);
        assertNotEquals(emailInvalido2, user);
        assertNotEquals(emailInvalido3, user);
        assertNotEquals(emailInvalido4, user);
    }

    @Test
    @DisplayName("Retornar excecao quando email for null")
    void retornarExcecaoQuandoAcionadoEmailERetornarNull(){
        HttpStatus emailEsperado = null;
        List<VoluntarioDto> user = voluntarioService.listarTst();
        assertTrue(user.isEmpty());
        assertEquals(emailEsperado, voluntarioDto);
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar tipoUsuario")
    void retornarQuandoAcionadoDeveRetornaTipoUsuario(){
        Enum tipoUsuarioEsperado = TipoUsuarioEnum.VOLUNTARIO;
        Enum user = UsuarioBuilderTest.pesquisaVoluntario().getTipoUsuario();
        assertEquals(tipoUsuarioEsperado, user);
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar tipoUsuario invalido")
    void retornarQuandoAcionadoDeveRetornaTipoUsuarioInvalido(){
        Enum tipoUsuarioEsperado = TipoUsuarioEnum.VOLUNTARIO;
        Enum tipoUsuarioInvalido = TipoUsuarioEnum.EMPRESA;
        Enum user = UsuarioBuilderTest.pesquisaVoluntario().getTipoUsuario();
        assertEquals(tipoUsuarioEsperado, user);
        assertNotEquals(tipoUsuarioInvalido, user);
    }

    @Test
    @DisplayName("Retornar excecao quando tipoUsuario for null")
    void retornarExcecaoQuandoAcionadoTipoUsuarioERetornarNull(){
         Enum tipoUsuarioEsperado = null;
        List<VoluntarioDto> user = voluntarioService.listarTst();
        assertTrue(user.isEmpty());
        assertEquals(tipoUsuarioEsperado, voluntarioDto);
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar telefone")
    void retornarQuandoAcionadoDeveRetornaTelefone(){
        String telefoneEsperado = "(11)95489-6439";
        String user = UsuarioBuilderTest.pesquisaVoluntario().getTelefone();
        assertEquals(telefoneEsperado, user);
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar telefone invalido")
    void retornarQuandoAcionadoDeveRetornaTelefoneInvalido(){
        String telefoneEsperado = "(11)95489-6439";
        String telefoneInvalido = "(11) 5489-6439";
        String telefoneInvalido2 = "(11) 5489-6439";
        String telefoneInvalido3 = "(11) 95489-643";
        String telefoneInvalido4 = "(11) 95489-64";
        String telefoneInvalido5 = "(11) 95489-64";
        String telefoneInvalido6 = "(11) 95489-6";
        String telefoneInvalido7 = "(11) 95489-";
        String telefoneInvalido8 = "95489-6439";

        String user = UsuarioBuilderTest.pesquisaVoluntario().getTelefone();
        assertEquals(telefoneEsperado, user);

        assertNotEquals(telefoneInvalido, user);
        assertNotEquals(telefoneInvalido2, user);
        assertNotEquals(telefoneInvalido3, user);
        assertNotEquals(telefoneInvalido4, user);
        assertNotEquals(telefoneInvalido5, user);
        assertNotEquals(telefoneInvalido6, user);
        assertNotEquals(telefoneInvalido7, user);
        assertNotEquals(telefoneInvalido8, user);
    }

    @Test
    @DisplayName("Retornar excecao quando telefone for null")
    void retornarExcecaoQuandoAcionadoTelefoneERetornarNull(){
        HttpStatus telefoneEsperado = null;
        List<VoluntarioDto> user = voluntarioService.listarTst();
        assertTrue(user.isEmpty());
        assertEquals(telefoneEsperado, voluntarioDto);
    }


    @Test
    @DisplayName("Retornar quando acionado deve retornar cpf")
    void retornarQuandoAcionadoDeveRetornaCpf(){
        String cpfEsperado = "523.901.544.22";
        String user = UsuarioBuilderTest.pesquisaVoluntario().getCpf();
        assertEquals(cpfEsperado, user);
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar cpf invalido")
    void retornarQuandoAcionadoDeveRetornaCpfInvalido(){
        String cpfEsperado = "523.901.544.22";
        String cpfInvalido = "526.938.2d3.22";
        String cpfInvalido2 = "das.dfs.wwq.cc";
        String cpfInvalido3 = "526.938.23.222";
        String cpfInvalido4 = "526.938.233.2";
        String user = UsuarioBuilderTest.pesquisaVoluntario().getCpf();
        assertEquals(cpfEsperado, user);
        assertNotEquals(cpfInvalido, user);
        assertNotEquals(cpfInvalido2, user);
        assertNotEquals(cpfInvalido3, user);
        assertNotEquals(cpfInvalido4, user);
    }


    @Test
    @DisplayName("Retornar excecao quando cpf for null")
    void retornarExcecaoQuandoAcionadoCpfERetornarNull(){
        HttpStatus cpfEsperado = null;
        List<VoluntarioDto> user = voluntarioService.listarTst();
        assertTrue(user.isEmpty());
        assertEquals(cpfEsperado, voluntarioDto);
    }

}