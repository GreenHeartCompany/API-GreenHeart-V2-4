package api.controllers;

import api.dto.empresa.EmpresaDto;
import api.dto.empresa.EmpresaAtualizadaParcial;
import api.domain.empresa.Empresa;
import api.service.empresa.EmpresaService;
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

@Tag(name = "Empresas", description = "Requisições empresas")
@RestController
@Controller
@RequestMapping("/empresas")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @Operation(summary = "Cadastra uma nova empresa.")
    @ApiResponses({@ApiResponse(responseCode = "400", description = "Empresa Inválido.", content = @Content(schema = @Schema(hidden = true))), @ApiResponse(responseCode = "201", description = "Empresa criado."),})
    @PostMapping("/cadastrar")
    public ResponseEntity<EmpresaDto> cadastrar(@RequestBody @Valid EmpresaDto novaEmpresa) throws Exception {
        return ResponseEntity.created(null).body(empresaService.cadastrar(novaEmpresa));
    }

    @Operation(summary = "Lista todos as empresas existentes.")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Não há empresas na lista.", content = @Content(schema = @Schema(hidden = true))), @ApiResponse(responseCode = "200", description = "Lista de empresas."),})
    @GetMapping
    public ResponseEntity<List<EmpresaDto>> listar() {
        return ResponseEntity.ok(empresaService.listar());
    }

    @Operation(summary = "Busca empresa por CNPJ.")
    @ApiResponses({@ApiResponse(responseCode = "404", description = "Empresa não encontrado.", content = @Content(schema = @Schema(hidden = true))), @ApiResponse(responseCode = "200", description = "Empresa buscado por CNPJ."),})
    @GetMapping("/buscar-por-cnpj")
    public ResponseEntity<List<EmpresaDto>> buscarPorCnpj(@RequestParam String cnpj) {
        return ResponseEntity.ok(empresaService.buscarPorCnpj(cnpj));
    }

    @Operation(summary = "Atualiza empresa por ID.")
    @ApiResponses({@ApiResponse(responseCode = "404", description = "Empresa não encontrado.", content = @Content(schema = @Schema(hidden = true))), @ApiResponse(responseCode = "200", description = "Voluntário atualizado."),})
    @PutMapping("/{id}")
    public ResponseEntity<Optional<EmpresaDto>> atualizar(@PathVariable Long id, @RequestBody @Valid EmpresaDto empresaDto) {
        return ResponseEntity.created(null).body(empresaService.atualizar(id, empresaDto));
    }

    @Operation(summary = "Deleta empresa por ID.")
    @ApiResponse(responseCode = "204", content = @Content(schema = @Schema(hidden = true)))
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        empresaService.deletar(id);
        return ResponseEntity.status(204).build();
    }

    @Operation(summary = "Atualiza parâmetros especifícos do empresa.")
    @ApiResponses({@ApiResponse(responseCode = "404", description = "Empresa não encontrado.", content = @Content(schema = @Schema(hidden = true))), @ApiResponse(responseCode = "200", description = "Empresa atualizado."),})
    @PatchMapping("/{indice}")
    public Optional<EmpresaDto> atualizacaoParcial(@PathVariable Long id, @RequestBody @Valid EmpresaAtualizadaParcial empresaAtualizada) {
        return empresaService.atualizacaoParcial(id, empresaAtualizada);
    }

    @Operation(summary = "Lista todos as empresas existentes.")
    @ApiResponses({@ApiResponse(responseCode = "404", description = "Empresa não encontrada.", content = @Content(schema = @Schema(hidden = true))), @ApiResponse(responseCode = "200", description = ""),})
    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<Optional<Empresa>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.buscarPorId(id));
    }
}
