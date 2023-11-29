package api.dto.publicacao;

import api.domain.empresa.Empresa;
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
        return post;
    }

    public static Publicacao convert(PublicacaoDto publicacaoDto, Empresa empresa){
        Publicacao post = new Publicacao();
        post.setTitulo(publicacaoDto.getTitulo());
        post.setDescricao(publicacaoDto.getDescricao());
        post.setTipoAcao(publicacaoDto.getTipoAcao());
        post.setTotalHrTrabalho(publicacaoDto.getTotalHrTrabalho());
        post.setNomeOrganizador(publicacaoDto.getNomeOrganizador());
        post.setEmailOrganizador(publicacaoDto.getEmailOrganizador());
        post.setTelOrganizador(publicacaoDto.getTelOrganizador());
        post.setEmpresa(empresa);
        return post;
    }
}
