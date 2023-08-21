package heart.green.api.builder;

import api.domain.empresa.Empresa;
import api.domain.plano.Plano;
import api.domain.publicacao.Publicacao;

import java.sql.Time;
import java.util.List;

public class PublicacaoBuilderTest {
    private PublicacaoBuilderTest(){
        throw new IllegalStateException("Classe Utilitária");
    }
    public static Publicacao criarPublicacaoConsulta(){
        return new Publicacao(1L, "Plantação no parque", "Plantação de arvores no parque", "Plantação", Time.valueOf("02:00:00"),
                "Hans", "hans@email.com", "(11)973747372", new Empresa("53.515.052/0001-67", new Plano()));
    }
    public static List<Publicacao> criarListaPublicacao(){
        return List.of(
                new Publicacao(1L, "Plantação no parque", "Plantação de arvores no parque", "Plantação", Time.valueOf("02:00:00"),
                         "Hans", "hans@email.com", "(11)973747372", new Empresa("53.515.052/0001-67", new Plano())),

                new Publicacao(2L, "Coleta de lixo", "Coleta de lixo no parque", "Coleta", Time.valueOf("02:00:00"),
                         "Hans", "hans@email.com", "(11)973747372", new Empresa("53.515.052/0001-67", new Plano())),

                new Publicacao(3L, "Limpeza de rua", "Limpeza de rua na sé", "Limpeza", Time.valueOf("02:00:00"),
                       "Hans", "hans@email.com", "(11)973747372", new Empresa("53.515.052/0001-67", new Plano()))
        );
    }
}