package com.desafio.digix.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desafio.digix.models.PontuacaoFamilia;
import com.desafio.digix.repository.PontuacaoFamiliaRepository;

@RestController
@RequestMapping(path = {"/api/v1/pontuacoesfamilias"}, produces = {"application/json"})
public class PontuacaoFamiliaController {
    private final PontuacaoFamiliaRepository pontuacaoFamiliaRepository;

    public PontuacaoFamiliaController(PontuacaoFamiliaRepository pontuacaoFamiliaRepository) {
        this.pontuacaoFamiliaRepository = pontuacaoFamiliaRepository;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PontuacaoFamilia>> buscarTodos() {
        Iterable<PontuacaoFamilia> iterable = pontuacaoFamiliaRepository.findAll();
        List<PontuacaoFamilia> pontuacaoFamilias = new ArrayList<>();
        iterable.forEach(pontuacaoFamilias::add);
        return ResponseEntity.ok().body(pontuacaoFamilias);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PontuacaoFamilia> criar(@RequestBody PontuacaoFamilia pontuacaoFamilia) {
        PontuacaoFamilia novaPontuacao = pontuacaoFamiliaRepository.save(pontuacaoFamilia);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPontuacao);
    }
}