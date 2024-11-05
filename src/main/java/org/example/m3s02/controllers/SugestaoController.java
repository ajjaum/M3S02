package org.example.m3s02.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.m3s02.entities.SugestaoEntity;
import org.example.m3s02.services.SugestaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Sugestão Controller", description = "Operações relacionadas a sugestões")
@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/sugestoes")
public class SugestaoController {
    private static final Logger logger = LoggerFactory.getLogger(SugestaoController.class);
    private final SugestaoService sugestaoService;

    @Operation(summary = "Criar uma nova sugestão", description = "Cria uma nova sugestão com base nas informações fornecidas.")
    @PostMapping
    public void criarSugestao(@RequestBody SugestaoEntity sugestao) {
        logger.info("Recebendo solicitação para criar nova sugestão.");

        sugestaoService.criarSugestao(sugestao);
    }

    @Operation(summary = "Atualizar uma sugestão existente", description = "Atualiza uma sugestão existente com base no ID fornecido.")
    @PutMapping("/{id}")
    public void atualizarSugestao(@PathVariable Long id, @RequestBody SugestaoEntity sugestao) {
        logger.info("Recebendo solicitação para atualizar sugestão com id: " + id);

        sugestao.setId(id);
        sugestaoService.atualizarSugestao(sugestao);
    }

    @Operation(summary = "Buscar uma sugestão por ID", description = "Busca uma sugestão com base no ID fornecido.")
    @GetMapping("/{id}")
    public SugestaoEntity buscarSugestaoPorId(@PathVariable Long id) {
        logger.info("Recebendo solicitação para buscar sugestão com id: " + id);

        return sugestaoService.buscarSugestaoPorId(id);
    }

    @Operation(summary = "Listar todas as sugestões ordenadas por data de atualização", description = "Lista todas as sugestões, ordenadas por data de atualização de forma decrescente.")
    @GetMapping
    public List<SugestaoEntity> listarTodasSugestoes() {
        logger.info("Recebendo solicitação para listar todas as sugestões.");

        return sugestaoService.listarTodasSugestoes();
    }

    @Operation(summary = "Listar todas as sugestões ordenadas por data de atualização", description = "Lista todas as sugestões, ordenadas por data de atualização de forma decrescente.")
    @GetMapping("/{desc}")
    public List<SugestaoEntity> listarSugestoesOrdenadas() {
        logger.info("Recebendo solicitação para listar todas as sugestões ordenadas por data de atualização.");

        return sugestaoService.listarSugestoesOrdenadas();
    }
}
