package api.controllers;

import api.dto.usuario.UsuarioLoginDto;
import api.dto.usuario.UsuarioTokenDto;
import api.controllers.configuration.jwt.GerenciadorTokenJwt;
import api.service.usuario.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Login", description = "Realização de login, para geração de TOKEN.")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    @Autowired
    private GerenciadorTokenJwt gerenciadorTokenJwt;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
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
        return ResponseEntity.ok(usuarioService.autenticar(usuarioLoginDto));
    }
}
