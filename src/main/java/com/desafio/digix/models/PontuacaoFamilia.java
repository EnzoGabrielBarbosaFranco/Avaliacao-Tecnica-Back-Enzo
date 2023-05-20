package com.desafio.digix.models;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PontuacaoFamilia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int rendaTotal;

    @Column(nullable = false)
    private int numeroDependentes;

    public int calcularPontuacao() {
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

    public static void main(String[] args) {
        PontuacaoFamilia familia1 = PontuacaoFamilia.builder()
                .rendaTotal(910)
                .numeroDependentes(4)
                .build();
        int pontuacao1 = familia1.calcularPontuacao();
        System.out.println("Pontuação da Família 1: " + pontuacao1);
        //Esperado 6 pontos da Familía 1

        PontuacaoFamilia familia2 = PontuacaoFamilia.builder()
                .rendaTotal(1200)
                .numeroDependentes(2)
                .build();
        int pontuacao2 = familia2.calcularPontuacao();
        System.out.println("Pontuação da Família 2: " + pontuacao2);
        //Esperado 5 pontos da Familía 2

        PontuacaoFamilia familia3 = PontuacaoFamilia.builder()
                .rendaTotal(800)
                .numeroDependentes(4)
                .build();
        int pontuacao3 = familia3.calcularPontuacao();
        System.out.println("Pontuação da Família 3: " + pontuacao3);
        //Esperado 8 pontos da Familía 3

        PontuacaoFamilia familia4 = PontuacaoFamilia.builder()
                .rendaTotal(1500)
                .numeroDependentes(3)
                .build();
        int pontuacao4 = familia4.calcularPontuacao();
        System.out.println("Pontuação da Família 4: " + pontuacao4);
        //Esperado 6 pontos da Familía 4
    }
}