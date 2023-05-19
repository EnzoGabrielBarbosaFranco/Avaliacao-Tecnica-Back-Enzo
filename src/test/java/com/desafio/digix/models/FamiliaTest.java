package com.desafio.digix.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FamiliaTest {
    @Test
    public void deve_criar_uma_familia() {
        // Cria um objeto Familia para o teste
        String nomeResponsavel = "Enzo";
        int quantidadeDependentes = 1;
        double renda = 900;

        Familia familia = Familia.builder().nomeResponsavel(nomeResponsavel).quantidadeDependentes(quantidadeDependentes).renda(renda).build();

        // Verifica se o objeto foi criado corretamente
        Assertions.assertEquals(nomeResponsavel, familia.getNomeResponsavel());
        Assertions.assertEquals(quantidadeDependentes, familia.getQuantidadeDependentes());
        Assertions.assertEquals(renda, familia.getRenda());
    }

    @Test
    public void deve_excluir_uma_familia() {
        // Cria um objeto Familia para o teste
        String nomeResponsavel = "Enzo";
        int quantidadeDependentes = 1;
        double renda = 900;
        Familia familia = Familia.builder().nomeResponsavel(nomeResponsavel).quantidadeDependentes(quantidadeDependentes).renda(renda).build();

        // Chama o método de exclusão
        familia.excluir();

        // Verifica se o objeto foi excluído corretamente
        Assertions.assertEquals(0, familia.getQuantidadeDependentes());
        Assertions.assertNull(familia.getNomeResponsavel());
        Assertions.assertEquals(0, familia.getRenda());
    }

    @Test
    public void deve_atualizar_dados_de_uma_familia() {
        // Cria um objeto Familia para o teste
        String nomeResponsavel = "Enzo";
        int quantidadeDependentes = 1;
        double renda = 900;
        Familia familia = Familia.builder().nomeResponsavel(nomeResponsavel).quantidadeDependentes(quantidadeDependentes).renda(renda).build();

        // Realiza a atualização dos atributos
        String novoNomeResponsavel = "Gabriel Enzo";
        double novaRenda = 850;
        familia.setNomeResponsavel(novoNomeResponsavel);
        familia.setRenda(novaRenda);

        // Verifica se os atributos foram atualizados corretamente
        Assertions.assertEquals(novoNomeResponsavel, familia.getNomeResponsavel());
        Assertions.assertEquals(novaRenda, familia.getRenda());
    }

}