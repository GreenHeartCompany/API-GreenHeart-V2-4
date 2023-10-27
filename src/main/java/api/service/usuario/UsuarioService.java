package api.service.usuario;

import api.dto.usuario.UsuarioCriacaoDto;
import api.dto.usuario.UsuarioLoginDto;
import api.dto.usuario.UsuarioTokenDto;

public interface UsuarioService {
    UsuarioTokenDto autenticar(UsuarioLoginDto usuarioLoginDto);
    Boolean emailExiste(String email);
}
