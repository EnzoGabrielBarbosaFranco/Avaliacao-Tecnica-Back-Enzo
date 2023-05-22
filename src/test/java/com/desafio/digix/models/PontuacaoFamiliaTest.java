package com.desafio.digix.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PontuacaoFamiliaTest {

    @Test
    public void deve_calcular_pontuacao() {
        PontuacaoFamilia familia1 = PontuacaoFamilia.builder()
                .rendaTotal(910)
                .numeroDependentes(4)
                .build();
        int pontuacao1 = familia1.calcularPontuacao();
        assertEquals(6, pontuacao1, "Pontuação da Família 1 incorreta");

        PontuacaoFamilia familia2 = PontuacaoFamilia.builder()
                .rendaTotal(1200)
                .numeroDependentes(2)
                .build();
        int pontuacao2 = familia2.calcularPontuacao();
        assertEquals(5, pontuacao2, "Pontuação da Família 2 incorreta");

        PontuacaoFamilia familia3 = PontuacaoFamilia.builder()
                .rendaTotal(800)
                .numeroDependentes(4)
                .build();
        int pontuacao3 = familia3.calcularPontuacao();
        assertEquals(8, pontuacao3, "Pontuação da Família 3 incorreta");

        PontuacaoFamilia familia4 = PontuacaoFamilia.builder()
                .rendaTotal(1500)
                .numeroDependentes(3)
                .build();
        int pontuacao4 = familia4.calcularPontuacao();
        assertEquals(6, pontuacao4, "Pontuação da Família 4 incorreta");
    }
}