package api.dto.beneficio;

import api.domain.beneficio.Beneficio;

public class BeneficioMapper {
    public static Beneficio of(BeneficioDto beneficioRequest){
        Beneficio auxilio = new Beneficio();
        auxilio.setAlimentacao(beneficioRequest.getAlimentacao());
        auxilio.setHospedagem(beneficioRequest.getHospedagem());
        auxilio.setTransporte(beneficioRequest.getTransporte());
        auxilio.setPublicacao(beneficioRequest.getPublicacao());
        return auxilio;
    }
}
