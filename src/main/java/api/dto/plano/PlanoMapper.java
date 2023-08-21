package api.dto.plano;

import api.domain.plano.Plano;

public class PlanoMapper {
    public static Plano to(PlanoDto planoDto){
        Plano plano = new Plano();
        plano.setTituloPlano(plano.getTituloPlano());
        plano.setDescricao(plano.getDescricao());
        plano.setTempoDuracao(planoDto.getTempoDuracao());
        plano.setValor(plano.getValor());
        return plano;
    }
}
