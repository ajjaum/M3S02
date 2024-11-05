package org.example.m3s02.repositories;

import org.example.m3s02.entities.ComentarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<ComentarioEntity, Long> {
}
