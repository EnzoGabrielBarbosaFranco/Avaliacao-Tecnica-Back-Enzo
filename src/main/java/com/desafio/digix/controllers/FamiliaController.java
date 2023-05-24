package com.desafio.digix.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desafio.digix.models.Familia;
import com.desafio.digix.models.PontuacaoFamilia;
import com.desafio.digix.repository.FamiliaRepository;
import com.desafio.digix.services.PontuacaoService;

@RestController
@RequestMapping(path = { "/api/v1/familias" }, produces = { "application/json" })
public class FamiliaController {
    @Autowired
    private FamiliaRepository familiaRepository;
    @Autowired
    private PontuacaoService pontuacaoService;

    public FamiliaController(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Familia>> buscarTodos() {
        Iterable<Familia> iterable = familiaRepository.findAll();
        List<Familia> familias = new ArrayList<>();
        iterable.forEach(familias::add);
        Collections.sort(familias, Comparator.comparingInt(Familia::getPontuacao).reversed());
        return ResponseEntity.ok().body(familias);
    }
    @GetMapping("/familiasRankeadas")
    public ResponseEntity<List<PontuacaoFamilia>> obterPontuacoesOrdenadas() {
        List<PontuacaoFamilia> pontuacoesOrdenadas = pontuacaoService.obterPontuacoesOrdenadas();
        return ResponseEntity.ok(pontuacoesOrdenadas);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Familia> criar(@RequestBody Familia familia) {
        Familia novaFamilia = familiaRepository.save(familia);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaFamilia);
    }
}