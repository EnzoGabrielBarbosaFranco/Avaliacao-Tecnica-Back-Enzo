package com.desafio.digix.models;

import java.util.Arrays;
import java.util.List;
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
    @Column()
    private int numeroDependentes;
    @Column()
    private double rendaTotal;
    @Column(nullable = false)
    private String nomeResponsavel;

    public int getPontuacao() {
        int pontuacao = 0;

        if (rendaTotal <= 900) {
            pontuacao += 5;
        } else if (rendaTotal >= 901 && rendaTotal <= 1500) {
            pontuacao += 3;
        }

        int numeroDependentesValidos = numeroDependentes - contarDependentesMenoresDe18Anos();

        if (numeroDependentesValidos >= 3) {
            pontuacao += 3;
        } else if (numeroDependentesValidos >= 1 && numeroDependentesValidos <= 2) {
            pontuacao += 2;
        }

        return pontuacao;
    }

    private int contarDependentesMenoresDe18Anos() {
        List<Integer> idadesDependentes = Arrays.asList(16, 20, 14, 25, 17);

        int contador = 0;
        for (int idade : idadesDependentes) {
            if (idade < 18) {
            }
        }
        return contador;
    }

    public void excluir() {
        this.id = 0;
        this.nomeResponsavel = null;
        this.numeroDependentes = 0;
        this.rendaTotal = 0;
    }
}
