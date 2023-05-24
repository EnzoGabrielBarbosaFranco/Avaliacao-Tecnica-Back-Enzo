package com.desafio.digix.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FamiliaTest {
    @Test
    public void deve_criar_uma_familia() {
        // Cria um objeto Familia para o teste
        String nomeResponsavel = "Enzo";
        int numeroDependentes = 1;
        double rendaTotal = 900;

        Familia familia = Familia.builder().nomeResponsavel(nomeResponsavel).numeroDependentes(numeroDependentes).rendaTotal(rendaTotal).build();

        // Verifica se o objeto foi criado corretamente
        Assertions.assertEquals(nomeResponsavel, familia.getNomeResponsavel());
        Assertions.assertEquals(numeroDependentes, familia.getNumeroDependentes());
        Assertions.assertEquals(rendaTotal, familia.getRendaTotal());
    }

    @Test
    public void deve_excluir_uma_familia() {
        // Cria um objeto Familia para o teste
        String nomeResponsavel = "Enzo";
        int numeroDependentes = 1;
        double rendaTotal = 900;
        Familia familia = Familia.builder().nomeResponsavel(nomeResponsavel).numeroDependentes(numeroDependentes).rendaTotal(rendaTotal).build();

        // Chama o método de exclusão
        familia.excluir();

        // Verifica se o objeto foi excluído corretamente
        Assertions.assertEquals(0, familia.getNumeroDependentes());
        Assertions.assertNull(familia.getNomeResponsavel());
        Assertions.assertEquals(0, familia.getRendaTotal());
    }

    @Test
    public void deve_atualizar_dados_de_uma_familia() {
        // Cria um objeto Familia para o teste
        String nomeResponsavel = "Enzo";
        int numeroDependentes = 1;
        double rendaTotal = 900;
        Familia familia = Familia.builder().nomeResponsavel(nomeResponsavel).numeroDependentes(numeroDependentes).rendaTotal(rendaTotal).build();

        // Realiza a atualização dos atributos
        String novoNomeResponsavel = "Gabriel Enzo";
        double novaRendaTotal = 850;
        familia.setNomeResponsavel(novoNomeResponsavel);
        familia.setRendaTotal(novaRendaTotal);

        // Verifica se os atributos foram atualizados corretamente
        Assertions.assertEquals(novoNomeResponsavel, familia.getNomeResponsavel());
        Assertions.assertEquals(novaRendaTotal, familia.getRendaTotal());
    }
}