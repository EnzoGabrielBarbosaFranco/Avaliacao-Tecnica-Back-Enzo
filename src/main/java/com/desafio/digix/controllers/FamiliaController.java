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
import com.desafio.digix.models.Familia;
import com.desafio.digix.repository.FamiliaRepository;

@RestController
@RequestMapping(path = {"/api/v1/familias"}, produces = {"application/json"})
public class FamiliaController {
    private final FamiliaRepository familiaRepository;

    public FamiliaController(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Familia>> buscarTodos() {
        Iterable<Familia> iterable = familiaRepository.findAll();
        List<Familia> familias = new ArrayList<>();
        iterable.forEach(familias::add);
        return ResponseEntity.ok().body(familias);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Familia> criar(@RequestBody Familia familia) {
        Familia novaFamilia = familiaRepository.save(familia);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaFamilia);
    }
}