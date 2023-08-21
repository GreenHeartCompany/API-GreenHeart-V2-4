package api.service.publicacao;

import api.dto.publicacao.PublicacaoDto;
import api.domain.publicacao.Publicacao;

import javax.mail.MessagingException;

public interface PublicacaoListener {

    void createPost(Publicacao publicacao, PublicacaoDto post) throws MessagingException;

}
