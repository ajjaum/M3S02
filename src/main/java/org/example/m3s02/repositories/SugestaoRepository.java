package org.example.m3s02.repositories;

import org.example.m3s02.entities.SugestaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SugestaoRepository extends JpaRepository<SugestaoEntity, Long> {
    List<SugestaoEntity> findAllByOrderByDataAtualizacaoDesc();
}
