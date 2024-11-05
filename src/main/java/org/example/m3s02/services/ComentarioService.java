package org.example.m3s02.services;

import org.example.m3s02.entities.ComentarioEntity;

import java.util.List;

public interface ComentarioService {
    void criarComentario(ComentarioEntity comentario);

    ComentarioEntity buscarComentarioPorId(Long id);

    List<ComentarioEntity> listarTodosComentarios();
}
