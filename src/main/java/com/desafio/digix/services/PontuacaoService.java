package com.desafio.digix.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.desafio.digix.models.PontuacaoFamilia;
import com.desafio.digix.repository.PontuacaoFamiliaRepository;

@Service
public class PontuacaoService {
    private final PontuacaoFamiliaRepository pontuacaoFamiliaRepository;

    public PontuacaoService(PontuacaoFamiliaRepository pontuacaoFamiliaRepository) {
        this.pontuacaoFamiliaRepository = pontuacaoFamiliaRepository;
    }

    public List<PontuacaoFamilia> listarPontuacoes() {
        return pontuacaoFamiliaRepository.findAll();
    }

    public PontuacaoFamilia obterPontuacaoPorId(Long id) {
        Optional<PontuacaoFamilia> pontuacaoFamilia = pontuacaoFamiliaRepository.findById(id);
        if (pontuacaoFamilia.isPresent()) {
            return pontuacaoFamilia.get();
        } else {
            throw new RuntimeException("Pontuação da Família não encontrada");
        }
    }

    public PontuacaoFamilia salvarPontuacao(PontuacaoFamilia pontuacaoFamilia) {
        return pontuacaoFamiliaRepository.save(pontuacaoFamilia);
    }

    public void excluirPontuacao(Long id) {
        pontuacaoFamiliaRepository.deleteById(id);
    }
}