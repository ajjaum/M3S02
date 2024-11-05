package org.example.m3s02.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Detalhes sobre o comentário")
@Data
@Entity
@Table(name = "comentario")
public class ComentarioEntity {

    @Schema(description = "O ID exclusivo do comentário", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Schema(description = "A sugestão à qual o comentário está relacionado", required = true)
    @ManyToOne
    @JoinColumn(name = "sugestaoId")
    private SugestaoEntity sugestaoId;

    @Schema(description = "O texto do comentário", example = "Este é um comentário.", required = true)
    private String texto;

    @Schema(description = "A data e hora em que o comentário foi enviado", example = "2024-11-04T23:20:00", required = true)
    private LocalDateTime dataEnvio;

}
