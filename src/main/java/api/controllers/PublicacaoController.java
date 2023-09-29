package api.controllers;

import api.repository.PublicacaoRepository;
import api.service.email.EmailService;
import api.dto.publicacao.PublicacaoDto;
import api.domain.arquivo.ArquivoTxt;
import api.domain.publicacao.Publicacao;
import api.service.empresa.EmpresaService;
import api.service.publicacao.PublicacaoListener;
import api.service.publicacao.PublicacaoService;
import api.service.publicacao.PublicacaoServiceImpl;
import api.util.enums.TipoPublicacaoEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Tag(name = "Publicação", description = "Requisições Publicação")
@Controller
@RestController
@RequestMapping("/publicacoes")
public class PublicacaoController {
    private final PublicacaoService publicacaoService;
    private final EmailService emailService;
    private final PublicacaoRepository publicacaoRepository;
    private final EmpresaService empresaService;

    @Autowired
    public PublicacaoController(PublicacaoServiceImpl publicacaoService, EmailService emailService, PublicacaoRepository publicacaoRepository, EmpresaService empresaService) {
        this.publicacaoService = publicacaoService;
        this.emailService = emailService;
        this.publicacaoRepository = publicacaoRepository;
        this.empresaService = empresaService;
    }

    @Operation(summary = "Criar Publicação.")
    @ApiResponses({
            @ApiResponse(responseCode = "400",
                    description = "Publicação Inválida.",
                    content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "201", description = "Publicação criada."),
    })
    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000/feed-empresa")
    public ResponseEntity<Publicacao> createPost(@RequestBody PublicacaoDto publicacaoDto) {
        publicacaoService.addPublicacaoListener(new PublicacaoListener() {
            @Override
            public void createPost(Publicacao publicacao, PublicacaoDto post) throws MessagingException {
                emailService.enviaEmail("wagnerasilva2013@gmail.com",
                        "publicacao criada com sucesso!!");
            }
        });
        return ResponseEntity.created(null).body(publicacaoService.createPost(publicacaoDto));
    }

    @Operation(summary = "Editar publicação feita.")
    @ApiResponses({
            @ApiResponse(responseCode = "400",
                    description = "Publicação Inválido.",
                    content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "200", description = "Publicação criada."),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Optional<Publicacao>> editPost(
            @PathVariable Long id,
            @RequestBody @Valid PublicacaoDto publicacaoDto) {
        return ResponseEntity.ok(publicacaoService.atualizarPub(id, publicacaoDto));
    }

    @Operation(summary = "Deletar publicação por ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "404",
                    description = "Publicação não encontrada.",
                    content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "204",
                    description = "Publicação excluida."),
    })
    @DeleteMapping("/id")
    public ResponseEntity<Publicacao> excluirPost(@PathVariable Long id) {
        publicacaoService.excluirPublicacao(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar publicação.")
    @ApiResponses({
            @ApiResponse(responseCode = "404",
                    description = "Publicação não encontrada.",
                    content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "200", description = ""),
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Publicacao>> buscarPorId(
            @PathVariable Long id) {
        return ResponseEntity.ok(publicacaoService.buscarPorId(id));
    }

    @GetMapping("/filtrar/{tipoPublicacao}")
    public ResponseEntity<List<Publicacao>> filtrarPorTipo(
            @PathVariable String tipoPublicacao) {
        return ResponseEntity.ok(publicacaoService.filtrar(tipoPublicacao));
    }
}
