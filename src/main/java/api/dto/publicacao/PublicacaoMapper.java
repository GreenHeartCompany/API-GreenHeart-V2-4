package api.dto.publicacao;

import api.domain.publicacao.Publicacao;

public class PublicacaoMapper {
    public static Publicacao of(PublicacaoDto publicacaoDto){
        Publicacao post = new Publicacao();
        post.setTitulo(publicacaoDto.getTitulo());
        post.setDescricao(publicacaoDto.getDescricao());
        post.setTipoAcao(publicacaoDto.getTipoAcao());
        post.setTotalHrTrabalho(publicacaoDto.getTotalHrTrabalho());
        post.setNomeOrganizador(publicacaoDto.getNomeOrganizador());
        post.setEmailOrganizador(publicacaoDto.getEmailOrganizador());
        post.setTelOrganizador(publicacaoDto.getTelOrganizador());
        post.setFkEmpresa(publicacaoDto.getFkEmpresa());
        return post;
    }
}
