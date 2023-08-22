package api.controllers;

import api.domain.voluntario.Voluntario;
import api.dto.voluntario.VoluntarioAtualizadoParcial;
import api.dto.voluntario.VoluntarioDto;
import api.dto.voluntario.VoluntarioListaDto;
import api.service.voluntario.VoluntarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Tag(name = "Voluntário", description = "Requisições voluntário")
@Controller
@RestController
@RequestMapping("/voluntarios")
public class VoluntarioController {
    private final VoluntarioService voluntarioService;

    @Autowired
    public VoluntarioController(VoluntarioService voluntarioService) {
        this.voluntarioService = voluntarioService;
    }

    @Operation(summary = "Cadastra um novo voluntário.")
    @ApiResponses({
                    @ApiResponse
                    (responseCode = "400",
                            description = "Voluntário Inválido.",
                            content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "201",
                            description = "Voluntário criado.")})
    @PostMapping("/cadastrar")
    @CrossOrigin("http://localhost:3000/cadastro-voluntario")
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid VoluntarioDto voluntarioDto) {
        voluntarioService.cadastrar(voluntarioDto);
        return ResponseEntity.created(null).build();
    }

    @Operation(summary = "Lista todos os voluntário existentes.")
    @ApiResponses({
            @ApiResponse(responseCode = "204",
                    description = "Não há voluntários na lista.",
                    content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "200",
                    description = "Lista de voluntários.")})
    @GetMapping
    public ResponseEntity<List<VoluntarioListaDto>> listar() {
        return ResponseEntity.ok(voluntarioService.listar());
    }

    @Operation(summary = "Busca voluntário por CPF.")
    @ApiResponses({
            @ApiResponse(responseCode = "404",
                    description = "Voluntário não encontrado.",
                    content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "200", description = "Voluntário buscado por CPF."),
    })
    @GetMapping("buscar-por-cpf")
    public ResponseEntity<List<api.dto.voluntario.VoluntarioDto>> buscarPorCpf(@RequestParam String cpf) {
        return ResponseEntity.ok(voluntarioService.buscarPorCpf(cpf));
    }

    @Operation(summary = "Atualiza voluntário por ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "404",
                    description = "Voluntário não encontrado.",
                    content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "200",
                    description = "Voluntário atualizado."),})
    @PutMapping("/{id}")
    public ResponseEntity<Optional<api.dto.voluntario.VoluntarioDto>> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid VoluntarioDto voluntarioDto) {
        return ResponseEntity.ok(voluntarioService.atualizar(id, voluntarioDto));
    }

    @Operation(summary = "Deleta voluntário por ID.")
    @ApiResponse(responseCode = "204",
            content = @Content(schema = @Schema(hidden = true)))
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        voluntarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Atualiza parâmetros especifícos do voluntário.")
    @ApiResponses({
            @ApiResponse(responseCode = "404",
                    description = "Voluntário não encontrado.",
                    content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "200",
                    description = "Voluntário atualizado."),})
    @PatchMapping("/{indice}")
    public ResponseEntity<Optional<api.dto.voluntario.VoluntarioDto>> atualizacaoParcial(
            @PathVariable Long id,
            @RequestBody @Valid VoluntarioAtualizadoParcial voluntarioAtualizado) {
        var voluntario = voluntarioService.atualizacaoParcial(id, voluntarioAtualizado);
        if (voluntario.isPresent()) {
            return ResponseEntity.status(200).body(voluntario);
        }
        return ResponseEntity.status(404).build();
    }
}
