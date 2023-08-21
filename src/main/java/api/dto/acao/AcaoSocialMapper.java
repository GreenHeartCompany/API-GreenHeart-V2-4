package api.dto.acao;

import api.domain.acao.AcaoSocial;

public class AcaoSocialMapper {
    public static AcaoSocial of(AcaoSocialDto acaoSocialDto){
        AcaoSocial acao = new AcaoSocial();
        acao.setDataHora(acaoSocialDto.getDataHora());
        return acao;
    }
}
