package com.desafio.digix.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.desafio.digix.controllers.FamiliaController;
import com.desafio.digix.repository.FamiliaRepository;

public class FamiliaTest {

    private FamiliaController familiaController;

    @Mock
    private FamiliaRepository familiaRepository;

    @BeforeEach
    void setup() {
            MockitoAnnotations.openMocks(this);
            familiaController = new FamiliaController(familiaRepository);
    }

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

    @Test
    void deve_buscar_todas_as_familias_ordenadas() {
            // Dados de exemplo
            Familia familia1 = new Familia();
            familia1.setId(1);
            familia1.setNumeroDependentes(3);
            familia1.setRendaTotal(1000.0);
            familia1.setNomeResponsavel("João");

            Familia familia2 = new Familia();
            familia2.setId(2);
            familia2.setNumeroDependentes(2);
            familia2.setRendaTotal(1200.0);
            familia2.setNomeResponsavel("Maria");

            List<Familia> familias = Arrays.asList(familia2, familia1);

            // Simulação do comportamento do repositório
            when(familiaRepository.findAll()).thenReturn(familias);

            // Executa o método buscarTodos()
            ResponseEntity<List<Familia>> responseEntity = familiaController.buscarTodos();

            // Verifica se a resposta tem status 200 OK
            assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

            // Verifica se a lista de famílias na resposta está correta
            List<Familia> familiasRetornadas = responseEntity.getBody();
            assertEquals(Arrays.asList(familia1, familia2), familiasRetornadas); // Verifica a ordem original

            // Simula a ordem correta esperada após a ordenação
            List<Familia> familiasOrdenadas = Arrays.asList(familia1, familia2);

            // Verifica se a lista de famílias está corretamente ordenada
            assertIterableEquals(familiasOrdenadas, familiasRetornadas);
    }

    @Test
    public void deve_calcular_pontuacao() {
            Familia familia1 = Familia.builder()
                            .rendaTotal(910)
                            .numeroDependentes(4)
                            .build();
            int pontuacao1 = familia1.getPontuacao();
            assertEquals(6, pontuacao1, "Pontuação da Família 1 incorreta");

            Familia familia2 = Familia.builder()
                            .rendaTotal(1200)
                            .numeroDependentes(2)
                            .build();
            int pontuacao2 = familia2.getPontuacao();
            assertEquals(5, pontuacao2, "Pontuação da Família 2 incorreta");

            Familia familia3 = Familia.builder()
                            .rendaTotal(800)
                            .numeroDependentes(4)
                            .build();
            int pontuacao3 = familia3.getPontuacao();
            assertEquals(8, pontuacao3, "Pontuação da Família 3 incorreta");

            Familia familia4 = Familia.builder()
                            .rendaTotal(1500)
                            .numeroDependentes(3)
                            .build();
            int pontuacao4 = familia4.getPontuacao();
            assertEquals(6, pontuacao4, "Pontuação da Família 4 incorreta");
    }
}