package org.example.m3s02.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Schema(description = "Detalhes sobre a sugestão")
@Data
@Entity
@Table(name = "sugestao")
public class SugestaoEntity {

    @Schema(description = "O ID exclusivo da sugestão", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Schema(description = "O título da sugestão", example = "Melhoria no sistema", required = true)
    private String titulo;

    @Schema(description = "A descrição completa da sugestão", example = "Descrição detalhada da sugestão", required = true)
    private String descricao;

    @Schema(description = "A data e hora em que a sugestão foi enviada", example = "2024-11-04T23:20:00", required = true)
    private LocalDateTime dataEnvio;

    @Schema(description = "A data e hora em que a sugestão sofreu alteração", example = "2024-11-05T10:30:00", required = true)
    private LocalDateTime dataAtualizacao;

    public SugestaoEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @PrePersist
    public void prePersist() {
        ZoneId zoneId = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        this.dataEnvio = zonedDateTime.toLocalDateTime();
        this.dataAtualizacao = zonedDateTime.toLocalDateTime();
    }

    @PreUpdate
    public void preUpdate() {
        ZoneId zoneId = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        this.dataAtualizacao = zonedDateTime.toLocalDateTime();
    }
}
