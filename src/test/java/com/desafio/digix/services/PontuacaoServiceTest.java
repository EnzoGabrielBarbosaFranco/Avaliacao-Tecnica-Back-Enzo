package com.desafio.digix.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.desafio.digix.models.PontuacaoFamilia;
import com.desafio.digix.repository.PontuacaoFamiliaRepository;

public class PontuacaoServiceTest {

    private PontuacaoService pontuacaoService;
    private PontuacaoFamiliaRepository pontuacaoFamiliaRepository;

    @BeforeEach
    public void setUp() {
        pontuacaoFamiliaRepository = mock(PontuacaoFamiliaRepository.class);
        pontuacaoService = new PontuacaoService(pontuacaoFamiliaRepository);
    }

    @Test
    public void deve_listar_pontuacoes() {
        List<PontuacaoFamilia> pontuacoesMock = new ArrayList<>();
        pontuacoesMock.add(new PontuacaoFamilia());
        pontuacoesMock.add(new PontuacaoFamilia());
        when(pontuacaoFamiliaRepository.findAll()).thenReturn(pontuacoesMock);

        List<PontuacaoFamilia> pontuacoes = pontuacaoService.listarPontuacoes();

        assertEquals(2, pontuacoes.size());
    }

    @Test
    public void deve_obter_pontuacao_por_id() {
        Long id = 1L;
        PontuacaoFamilia pontuacaoMock = new PontuacaoFamilia();
        when(pontuacaoFamiliaRepository.findById(id)).thenReturn(Optional.of(pontuacaoMock));

        PontuacaoFamilia pontuacao = pontuacaoService.obterPontuacaoPorId(id);

        assertEquals(pontuacaoMock, pontuacao);
    }

    @Test
    public void deve_obter_pontuacao_por_id_notFound() {
        Long id = 1L;
        when(pontuacaoFamiliaRepository.findById(id)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            pontuacaoService.obterPontuacaoPorId(id);
        });

        assertEquals("Pontuação da Família não encontrada", exception.getMessage());
    }

    @Test
    public void deve_salvar_pontuacao() {
        PontuacaoFamilia pontuacaoMock = new PontuacaoFamilia();
        when(pontuacaoFamiliaRepository.save(any(PontuacaoFamilia.class))).thenReturn(pontuacaoMock);

        PontuacaoFamilia pontuacao = pontuacaoService.salvarPontuacao(new PontuacaoFamilia());

        assertEquals(pontuacaoMock, pontuacao);
    }

    @Test
    public void deve_excluir_pontuacao() {
        Long id = 1L;

        pontuacaoService.excluirPontuacao(id);

        // Verifica se o método deleteById do repositório foi chamado com o ID correto
        verify(pontuacaoFamiliaRepository).deleteById(id);
    }
}