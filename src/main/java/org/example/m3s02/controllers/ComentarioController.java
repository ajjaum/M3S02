package org.example.m3s02.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.example.m3s02.entities.ComentarioEntity;
import org.example.m3s02.services.ComentarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Comentário Controller", description = "Operações relacionadas a comentários")
@Slf4j
@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    private static final Logger logger = LoggerFactory.getLogger(ComentarioController.class);
    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService; }

    @Operation(summary = "Criar um novo comentário", description = "Cria um novo comentário com base nas informações fornecidas.")
    @PostMapping
    public void criarComentario(@RequestBody ComentarioEntity comentario) {
        logger.info("Recebendo solicitação para criar novo comentário.");

        comentarioService.criarComentario(comentario);
    }

    @Operation(summary = "Buscar um comentário por ID", description = "Busca um comentário com base no ID fornecido.")
    @GetMapping("/{id}")
    public ComentarioEntity buscarComentarioPorId(@PathVariable Long id) {
        logger.info("Recebendo solicitação para buscar comentário com id: " + id);

        return comentarioService.buscarComentarioPorId(id);
    }

    @Operation(summary = "Listar todos os comentários", description = "Lista todos os comentários.")
    @GetMapping
    public List<ComentarioEntity> listarTodosComentarios() {
        logger.info("Recebendo solicitação para listar todos os comentários.");

        return comentarioService.listarTodosComentarios();
    }
}
