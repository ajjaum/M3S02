package org.example.m3s02.services.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.example.m3s02.entities.ComentarioEntity;
import org.example.m3s02.repositories.ComentarioRepository;
import org.example.m3s02.services.ComentarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ComentarioServiceImpl implements ComentarioService {
    private static final Logger logger = LoggerFactory.getLogger(ComentarioServiceImpl.class);
    private final ComentarioRepository comentarioRepository;

    public ComentarioServiceImpl(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public void criarComentario(ComentarioEntity comentario) {
        logger.info("Criando novo comentário para a sugestão: " + comentario.getSugestaoId().getId());
        comentarioRepository.save(comentario);
    }

    @Override
    public ComentarioEntity buscarComentarioPorId(Long id) {
        logger.info("Buscando comentário com id: " + id);
        Optional<ComentarioEntity> comentario = comentarioRepository.findById(id);

        return comentario.orElse(null);
    }
    @Override
    public List<ComentarioEntity> listarTodosComentarios() {
        logger.info("Listando todos os comentários.");
        return comentarioRepository.findAll();
    }
}
