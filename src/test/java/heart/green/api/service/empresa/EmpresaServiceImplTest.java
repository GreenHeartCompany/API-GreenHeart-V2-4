package heart.green.api.service.empresa;

import api.service.empresa.EmpresaServiceImpl;
import heart.green.api.builder.UsuarioBuilderTest;
import api.dto.empresa.EmpresaDto;
import api.repository.EmpresaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmpresaServiceImplTest {
    @Mock
    private EmpresaRepository empresaRepository;
    @InjectMocks
    private EmpresaServiceImpl empresaService;
    private EmpresaDto empresaDto;

    @Test
    @DisplayName("Listar quando acionado deve retornar empresas validas")
    void listarQuandoAcionadoDeveRetornarEmpresaValida(){
        Integer resultadoEsperado = 3;
        List<EmpresaDto> empresa = UsuarioBuilderTest.criarListaDeEmpresaDto();
        assertEquals(resultadoEsperado, empresa.size());
    }

    @Test
    @DisplayName("Listar quando acionado deve retornar lista vazia")
    void listarQuandoAcionadoRetornarListaPubliVazia(){
        Integer resultadoEsperado = 0;
        Mockito.when(empresaRepository.findAll()).thenReturn(List.of());
        List<EmpresaDto> resultado = empresaService.listar();
        assertTrue(resultado.isEmpty());
        assertEquals(resultadoEsperado, resultado.size());
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar nome")
    void retornarQuandoAcionadoDeveRetornaNome(){
        String nomeEsperado = "Green Peace";
        String empresaNome = UsuarioBuilderTest.listarEmpresaDto().getNome();
        assertEquals(nomeEsperado, empresaNome);
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar nome invalido")
    void retornarQuandoAcionadoDeveRetornaNomeInvalido(){
        String nomeEsperado = "Green Peace";
        String nomeInvalido = "";
        String nomeInvalido2 = "12345678";
        String nomeInvalido3 = "{})(&@$%!@#";
        String empresaNome = UsuarioBuilderTest.listarEmpresaDto().getNome();
        assertEquals(nomeEsperado, empresaNome);
        assertNotEquals(nomeInvalido, empresaNome);
        assertNotEquals(nomeInvalido2, empresaNome);
        assertNotEquals(nomeInvalido3, empresaNome);
    }

    @Test
    @DisplayName("Retornar excecao quando nome for null")
    void retornarExcecaoQuandoAcionadoNomeERetornarNull(){
        String nomeEsperado = null;
        List<EmpresaDto> empresaNome = empresaService.listar();
        assertTrue(empresaNome.isEmpty());
        assertEquals(nomeEsperado, empresaDto);
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar Email")
    void retornarQuandoAcionadoDeveRetornaEmail(){
        String emailEsperado = "gregan@greenpeace.org";
        String empresaEmail = UsuarioBuilderTest.listarEmpresaDto().getEmail();
        assertEquals(emailEsperado, empresaEmail);
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar email invalido")
    void retornarQuandoAcionadoDeveRetornaEmailInvalido(){
        String emailEsperado = "gregan@greenpeace.org";
        String emailInvalido = "gregangreenpeace.org";
        String emailInvalido2 = "gregan@greenpeace";
        String emailInvalido3 = "gregan@";
        String emailInvalido4 = "";
        String empresaEmail = UsuarioBuilderTest.listarEmpresaDto().getEmail();
        assertEquals(emailEsperado, empresaEmail);
        assertNotEquals(emailInvalido, empresaEmail);
        assertNotEquals(emailInvalido2, empresaEmail);
        assertNotEquals(emailInvalido3, empresaEmail);
        assertNotEquals(emailInvalido4, empresaEmail);
    }

    @Test
    @DisplayName("Retornar excecao quando Email for null")
    void retornarExcecaoQuandoAcionadoEmailERetornarNull(){
        String emailEsperado = null;
        List<EmpresaDto> empresaEmail = empresaService.listar();
        assertTrue(empresaEmail.isEmpty());
        assertEquals(emailEsperado, empresaDto);
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar telefone")
    void retornarQuandoAcionadoDeveRetornaTelefone(){
        String telefoneEsperado = "(11)3845-1938";
        String empresaTelefone = UsuarioBuilderTest.listarEmpresaDto().getTelefone();
        assertEquals(telefoneEsperado,empresaTelefone);
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar telefone invalido")
    void retornarQuandoAcionadoDeveRetornaTelefoneInvalido(){
        String telefoneEsperado = "(11)3845-1938";
        String telefoneInvalido = "3845-1938";
        String telefoneInvalido2 = "(11)3845-193";
        String telefoneInvalido3 = "(11)3845-19";
        String telefoneInvalido4 = "(11)3845-1";
        String telefoneInvalido5 = "(11)3845";
        String empresaTelefone = UsuarioBuilderTest.listarEmpresaDto().getTelefone();
        assertEquals(telefoneEsperado,empresaTelefone);
        assertNotEquals(telefoneInvalido, empresaTelefone);
        assertNotEquals(telefoneInvalido2, empresaTelefone);
        assertNotEquals(telefoneInvalido3, empresaTelefone);
        assertNotEquals(telefoneInvalido4, empresaTelefone);
        assertNotEquals(telefoneInvalido5, empresaTelefone);
    }

    @Test
    @DisplayName("Retornar excecao quando telefone for null")
    void retornarExcecaoQuandoAcionadoTelefoneERetornarNull(){
        String telefoneEsperado = null;
        List<EmpresaDto> empresaTelefone = empresaService.listar();
        assertTrue(empresaTelefone.isEmpty());
        assertEquals(telefoneEsperado, empresaDto);
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar cnpj")
    void retornarQuandoAcionadoDeveRetornaCNPJ(){
        String cnpjEsperado = "23-157-361/0001-98";
        String empresaCnpj = UsuarioBuilderTest.listarEmpresaDto().getCnpj();
        assertEquals(cnpjEsperado, empresaCnpj);
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar cnpj invalido")
    void retornarQuandoAcionadoDeveRetornaCNPJInvalido(){
        String cnpjEsperado = "23-157-361/0001-98";
        String cnpjInvalido = "23-157-36s/0001-98";
        String cnpjInvalido2 = "as.dsa.ert/sad-ds";
        String cnpjInvalido3 = "23-157-36s/0001";
        String empresaCnpj = UsuarioBuilderTest.listarEmpresaDto().getCnpj();
        assertEquals(cnpjEsperado, empresaCnpj);
        assertNotEquals(cnpjInvalido, empresaCnpj);
        assertNotEquals(cnpjInvalido2, empresaCnpj);
        assertNotEquals(cnpjInvalido3, empresaCnpj);
    }

    @Test
    @DisplayName("Retornar excecao quando cnpj for null")
    void retornarExcecaoQuandoAcionadoCnpjERetornarNull(){
        String cnpjEsperado = null;
        List<EmpresaDto> empresaCnpj = empresaService.listar();
        assertTrue(empresaCnpj.isEmpty());
        assertEquals(cnpjEsperado, empresaDto);
    }
}