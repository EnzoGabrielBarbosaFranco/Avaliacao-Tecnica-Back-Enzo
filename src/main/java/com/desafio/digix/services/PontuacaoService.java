package com.desafio.digix.services;

import com.desafio.digix.repository.PontuacaoFamiliaRepository;

public class PontuacaoService {
    private final PontuacaoFamiliaRepository pontuacaoFamiliaRepository;

    public PontuacaoService(PontuacaoFamiliaRepository pontuacaoFamiliaRepository) {
        this.pontuacaoFamiliaRepository = pontuacaoFamiliaRepository;
    }
}