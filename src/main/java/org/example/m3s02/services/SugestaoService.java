package org.example.m3s02.services;

import org.example.m3s02.entities.SugestaoEntity;

import java.util.List;

public interface SugestaoService {

    void criarSugestao(SugestaoEntity sugestao);

    void atualizarSugestao(SugestaoEntity sugestao);

    SugestaoEntity buscarSugestaoPorId(Long id);

    List<SugestaoEntity> listarTodasSugestoes();

    List<SugestaoEntity> listarSugestoesOrdenadas();
}
