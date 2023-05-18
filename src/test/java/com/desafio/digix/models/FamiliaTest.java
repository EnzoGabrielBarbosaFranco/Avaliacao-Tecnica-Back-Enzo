package com.desafio.digix.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FamiliaTest {
    @Test
    public void deve_criar_uma_familia() {
        // Cria um objeto Dependente para teste
        String nomeResponsavel = "Enzo";
        int quantidadeDependentes = 1;
        double renda = 900;

        Familia familia = Familia.builder().nomeResponsavel(nomeResponsavel).quantidadeDependentes(quantidadeDependentes).renda(renda).build();

        // Verifica se o objeto foi criado corretamente
        Assertions.assertEquals(nomeResponsavel, familia.getNomeResponsavel());
        Assertions.assertEquals(quantidadeDependentes, familia.getQuantidadeDependentes());
        Assertions.assertEquals(renda, familia.getRenda());
    }
}