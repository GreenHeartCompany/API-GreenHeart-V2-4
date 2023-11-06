package api.dto.plano;

import api.domain.plano.Plano;

public class PlanoMapper {
    public static Plano to(PlanoDto planoDto){
        Plano plano = new Plano();
        plano.setTituloPlano(planoDto.getTituloPlano());
        plano.setDescricao(planoDto.getDescricao());
        plano.setTempoDuracao(planoDto.getTempoDuracao());
        plano.setValor(planoDto.getValor());
        return plano;
    }
}
