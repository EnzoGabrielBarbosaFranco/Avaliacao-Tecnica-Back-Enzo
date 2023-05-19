package com.desafio.digix.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Familia {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private int quantidadeDependentes;
    @Column(nullable = false)
    private double renda;
    @Column(nullable = false)
    private String nomeResponsavel;

    public void excluir() {
        this.id = 0;
        this.nomeResponsavel = null;
        this.quantidadeDependentes = 0;
        this.renda = 0;
    }
}
