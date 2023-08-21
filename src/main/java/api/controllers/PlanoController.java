package api.controllers;

import api.dto.plano.PlanoDto;
import api.domain.plano.Plano;
import api.service.plano.PlanoService;
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
import java.util.List;
import java.util.Optional;

@Tag(name = "Planos", description = "Planos para as empresas.")
@Controller
@RequestMapping("/planos")
public class PlanoController {
    @Autowired
    private PlanoService planoService;

    @Operation(summary = "Cadastrar plano.")
    @ApiResponses({
            @ApiResponse(responseCode = "400",
                    description = "Plano inválido.",
                    content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "201", description = ""),
    })
    @PostMapping
    public ResponseEntity<Plano> criar(@RequestBody @Valid PlanoDto planoDto) {
        return ResponseEntity.created(null).body(planoService.criar(planoDto));
    }

    @Operation(summary = "Listar planos.")
    @ApiResponses({
            @ApiResponse(responseCode = "404",
                    description = "Plano não encontrado.",
                    content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "200", description = ""),
    })
    @GetMapping
    public ResponseEntity<List<Plano>> listar() {
        return ResponseEntity.ok(planoService.listar());
    }

    @Operation(summary = "Buscar planos empresariais.")
    @ApiResponses({
            @ApiResponse(responseCode = "404",
                    description = "Plano não encontrado.",
                    content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "200", description = ""),
    })
    @GetMapping("/buscar-plano/{id}")
    public ResponseEntity<Optional<Plano>> buscarPlano(@PathVariable Long id) {
        return ResponseEntity.ok(planoService.buscarPlanoPorId(id));
    }

    public ResponseEntity<Void> deletar(@RequestParam Long id) {
        planoService.deletar(id);
        return ResponseEntity.status(204).build();
    }
}
