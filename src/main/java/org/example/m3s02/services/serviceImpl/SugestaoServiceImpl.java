package org.example.m3s02.services.serviceImpl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.m3s02.entities.SugestaoEntity;
import org.example.m3s02.repositories.SugestaoRepository;
import org.example.m3s02.services.SugestaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class SugestaoServiceImpl implements SugestaoService {
    private static final Logger logger = LoggerFactory.getLogger(SugestaoServiceImpl.class);
    private final SugestaoRepository sugestaoRepository;

    @Override
    public void criarSugestao(SugestaoEntity sugestao) {
        logger.info("Criando nova sugestão: " + sugestao.getTitulo());
        sugestaoRepository.save(sugestao);
    }

    @Override public void atualizarSugestao(SugestaoEntity sugestao) {
        logger.info("Atualizando sugestão: " + sugestao.getId());
        sugestaoRepository.save(sugestao);
    }

    @Override
    public SugestaoEntity buscarSugestaoPorId(Long id) {
        logger.info("Buscando sugestão com id: " + id);
        Optional<SugestaoEntity> sugestao = sugestaoRepository.findById(id);

        return sugestao.orElse(null); }

    @Override
    public List<SugestaoEntity> listarTodasSugestoes() {
        logger.info("Listando todas as sugestões.");
        return sugestaoRepository.findAll();
    }

    @Override
    public List<SugestaoEntity> listarSugestoesOrdenadas() {
        logger.info("Listando todas as sugestões ordenadas por data de atualização.");

        return sugestaoRepository.findAllByOrderByDataAtualizacaoDesc();
    }
}
