package heart.green.api.service.publicacao;

import api.service.publicacao.PublicacaoServiceImpl;
import heart.green.api.builder.PublicacaoBuilderTest;
import api.domain.publicacao.Publicacao;
import api.repository.PublicacaoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Time;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PublicacaoServiceTest {
    @Mock
    private PublicacaoRepository publicacaoRepository;
    @InjectMocks
    private PublicacaoServiceImpl publicacaoService;
    @InjectMocks
    private Publicacao publicacao;

    @Test
    @DisplayName("Listar quando acionado deve retornar itens")
    void listarQuandoAcionadoDeveRetornarObjetosValidos(){
        int resultadoEsperado = 3;
        List<Publicacao> publicacao = PublicacaoBuilderTest.criarListaPublicacao();
        Mockito.when(publicacaoRepository.findAll()).thenReturn(publicacao);
        List<Publicacao> resultado = publicacaoService.listar();
        assertEquals(resultadoEsperado, resultado.size());
    }

    @Test
    @DisplayName("Listar quando acionado deve retornar lista vazia")
    void listarQuandoAcionadoRetornarListaPubliVazia(){
        int resultadoEsperado = 0;
        Mockito.when(publicacaoRepository.findAll()).thenReturn(List.of());
        List<Publicacao> resultado = publicacaoService.listar();
        assertTrue(resultado.isEmpty());
        assertEquals(resultadoEsperado, resultado.size());
    }

    @Test
    @DisplayName("Retornar excecao quando titulo for null")
    void retornarExcecaoQuandoAcionadoTituloERetornarNull(){
    String tituloEsperado = null;
    List<Publicacao> publi = publicacaoService.listar();
    assertTrue(publi.isEmpty());
    assertEquals(tituloEsperado, publicacao.getTitulo());
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar titulo")
    void retornarQuandoAcionadoDeveRetornarTitulo(){
        String tituloEsperado = "Plantação no parque";
        String publi = PublicacaoBuilderTest.criarPublicacaoConsulta().getTitulo();
        assertEquals(tituloEsperado, publi);
    }

    @Test
    @DisplayName("Retornar excecao quando descricao for null")
    void retornarExcecaoQuandoAcionadoDescricaoERetornarNull(){
        String descricaoEsperada = null;
        List<Publicacao> publi = publicacaoService.listar();
        assertTrue(publi.isEmpty());
        assertEquals(descricaoEsperada, publicacao.getDescricao());
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar descricao")
    void retornarQuandoAcionadoDeveRetornarDescricao(){
        String escricaoEsperada = "Plantação de arvores no parque";
        String publi = PublicacaoBuilderTest.criarPublicacaoConsulta().getDescricao();
        assertEquals(escricaoEsperada, publi);
    }

    @Test
    @DisplayName("Retornar excecao quando tipo de acao for null")
    void retornarExcecaoQuandoAcionadoTipoAcaoERetornarNull(){
        String tipoAcaoEsperado = null;
        List<Publicacao> publi = publicacaoService.listar();
        assertTrue(publi.isEmpty());
        assertEquals(tipoAcaoEsperado, publicacao.getTipoAcao());
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar tipo de acao")
    void retornarQuandoAcionadoDeveRetornarTipoAcao(){
        String tipoAcaoEsperado = "Plantação";
        String publi = PublicacaoBuilderTest.criarPublicacaoConsulta().getTipoAcao();
        assertEquals(tipoAcaoEsperado, publi);
    }

    @Test
    @DisplayName("Retornar excecao quando totalHrTrabalho for null")
    void retornarExcecaoQuandoAcionadoTotalHrTrabalhoERetornarNull(){
        Time totalHrTrabalho = null;
        List<Publicacao> publi = publicacaoService.listar();
        assertTrue(publi.isEmpty());
        assertEquals(totalHrTrabalho, publicacao.getTotalHrTrabalho());
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar totalHrTrabalho")
    void retornarQuandoAcionadoDeveRetornarTotalHrTrabalho(){
        Time totalHrTrabalho = Time.valueOf("02:00:00");
        Time publi = PublicacaoBuilderTest.criarPublicacaoConsulta().getTotalHrTrabalho();
        assertEquals(totalHrTrabalho, publi);
    }

    @Test
    @DisplayName("Retornar excecao quando nomeOrganizador for null")
    void retornarExcecaoQuandoAcionadonomeOrganizadorERetornarNull(){
        String nomeEsperado = null;
        List<Publicacao> publi = publicacaoService.listar();
        assertTrue(publi.isEmpty());
        assertEquals(nomeEsperado, publicacao.getNomeOrganizador());
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar nomeOrganizador")
    void retornarQuandoAcionadoDeveRetornarNomeOrganizador(){
        String nomeEsperado = "Hans";
        String publi = PublicacaoBuilderTest.criarPublicacaoConsulta().getNomeOrganizador();
        assertEquals(nomeEsperado, publi);
    }

    @Test
    @DisplayName("Retornar excecao quando EmailOrganizador for null")
    void retornarExcecaoQuandoAcionadoEmailOrganizadorERetornarNull(){
        String emailEsperado = null;
        List<Publicacao> publi = publicacaoService.listar();
        assertTrue(publi.isEmpty());
        assertEquals(emailEsperado, publicacao.getEmailOrganizador());
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar emailOrganizador")
    void retornarQuandoAcionadoDeveRetornarEmailOrganizador(){
        String emailEsperado = "hans@email.com";
        String publi = PublicacaoBuilderTest.criarPublicacaoConsulta().getEmailOrganizador();
        assertEquals(emailEsperado, publi);
    }

    @Test
    @DisplayName("Retornar excecao quando telefoneOrganizador for null")
    void retornarExcecaoQuandoAcionadoTelefoneOrganizadorERetornarNull(){
        String telefoneOrganizador = null;
        List<Publicacao> publi = publicacaoService.listar();
        assertTrue(publi.isEmpty());
        assertEquals(telefoneOrganizador, publicacao.getTelOrganizador());
    }

    @Test
    @DisplayName("Retornar quando acionado deve retornar telefoneOrganizador")
    void retornarQuandoAcionadoDeveRetornarTelefoneOrganizador(){
        String telefoneOrganizador = "(11)973747372";
        String publi = PublicacaoBuilderTest.criarPublicacaoConsulta().getTelOrganizador();
        assertEquals(telefoneOrganizador, publi);
    }
}