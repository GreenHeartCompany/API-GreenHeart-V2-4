package api.controllers;

import api.dto.usuario.UsuarioLoginDto;
import api.dto.usuario.UsuarioTokenDto;
import api.controllers.configuration.jwt.GerenciadorTokenJwt;
import api.service.usuario.UsuarioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="Login", description = "Realização de login, para geração de TOKEN.")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioServiceImpl usuarioServiceImpl;
    @Autowired
    private GerenciadorTokenJwt gerenciadorTokenJwt;

    @Autowired
    public UsuarioController(UsuarioServiceImpl usuarioServiceImpl) {
        this.usuarioServiceImpl = usuarioServiceImpl;
    }

    @Operation(summary = "Entrar na conta.")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Login realizado com sucesso."),
            @ApiResponse(responseCode = "400",
                    description = "E-mail ou senha incorreta.",
                    content = @Content(schema = @Schema(hidden = true)))
    })
    @PostMapping("/login")
    public ResponseEntity<UsuarioTokenDto> login(@RequestBody UsuarioLoginDto usuarioLoginDto){
        return ResponseEntity.ok(usuarioServiceImpl.autenticar(usuarioLoginDto));
    }

    @GetMapping("/verificar-email/{email}")
    public ResponseEntity<Boolean> FindByEmail(@PathVariable String email) {
        return ResponseEntity.ok(usuarioServiceImpl.emailExiste(email));
    }
}
