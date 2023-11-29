package api.dto.endereco;

import api.domain.mask.Mascara;
import api.domain.endereco.Endereco;
import api.domain.usuario.Usuario;

public class EnderecoMapper {
    public static Endereco to(EnderecoDto enderecoDto, Usuario usuario){
        Endereco endereco = new Endereco();
        endereco.setLogradouro(enderecoDto.getLogradouro());
        endereco.setCep(Mascara.formatCep(enderecoDto.getCep()));
        endereco.setNumero(enderecoDto.getNumero());
        endereco.setComplemento(enderecoDto.getComplemento());
        endereco.setUsuario(usuario);
        return endereco;
    }
}
