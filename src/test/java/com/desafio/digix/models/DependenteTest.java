package com.desafio.digix.models;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class DependenteTest {
    @Test
    public void deve_criar_um_dependente() {
        // Cria um objeto Dependente para o teste
        String nome = "Enzo";
        int idade = 17;
        Dependente dependente = Dependente.builder().nome(nome).idade(idade).build();

        // Verifica se o objeto foi criado corretamente
        Assertions.assertEquals(nome, dependente.getNome());
        Assertions.assertEquals(idade, dependente.getIdade());
    }

    @Test
    public void deve_excluir_um_dependente() {
        // Cria um objeto Dependente para o teste
        String nome = "Enzo";
        int idade = 17;
        Dependente dependente =  Dependente.builder().nome(nome).idade(idade).build();

        // Chama o método de exclusão
        dependente.excluir();

        // Verifica se o objeto foi excluído corretamente
        Assertions.assertEquals(0, dependente.getId());
        Assertions.assertNull(dependente.getNome());
        Assertions.assertEquals(0, dependente.getIdade());
    }

    @Test
    public void deve_atualizar_dados_de_um_dependente() {
        // Cria um objeto Dependente para o teste
        long id = 1;
        String nome = "Enzo";
        int idade = 17;
        Dependente dependente = Dependente.builder().id(id).nome(nome).idade(idade).build();

        // Realiza a atualização dos atributos
        String novoNome = "Gabriel Enzo";
        int novaIdade = 16;
        dependente.setNome(novoNome);
        dependente.setIdade(novaIdade);

        // Verifica se os atributos foram atualizados corretamente
        Assertions.assertEquals(id, dependente.getId());
        Assertions.assertEquals(novoNome, dependente.getNome());
        Assertions.assertEquals(novaIdade, dependente.getIdade());
    }

    @Test
    public void deve_filtrar_apenas_dependentes_com_menos_de_18_anos_de_idade() {
        // Cria uma lista de Dependentes para o teste
        List<Dependente> dependentes = new ArrayList<>();
        dependentes.add(Dependente.builder().id(1).nome("Enzo").idade(20).build());
        dependentes.add(Dependente.builder().id(2).nome("Gabriel").idade(17).build());
        dependentes.add(Dependente.builder().id(3).nome("Barbosa").idade(25).build());
        dependentes.add(Dependente.builder().id(4).nome("Franco").idade(18).build());

        // Filtra os dependentes com idade maior que 18 anos
        List<Dependente> dependentesFiltrados = filtrarDependentesMaioresDeIdade(dependentes);

        // Verifica se apenas os dependentes com idade menor de 18 anos foram mantidos
        Assertions.assertEquals(1, dependentesFiltrados.size());
        for (Dependente dependente : dependentesFiltrados) {
            Assertions.assertTrue(dependente.getIdade() < 18);
        }
    }

    private List<Dependente> filtrarDependentesMaioresDeIdade(List<Dependente> dependentes) {
        List<Dependente> dependentesFiltrados = new ArrayList<>();
        for (Dependente dependente : dependentes) {
            if (dependente.getIdade() < 18) {
                dependentesFiltrados.add(dependente);
            }
        }
        return dependentesFiltrados;
    }
}