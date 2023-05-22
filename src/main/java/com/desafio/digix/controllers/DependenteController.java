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
import com.desafio.digix.models.Dependente;
import com.desafio.digix.repository.DependenteRepository;

@RestController
@RequestMapping(path = {"/api/v1/dependentes"}, produces = {"application/json"})
public class DependenteController {
    private final DependenteRepository dependenteRepository;

    public DependenteController(DependenteRepository dependenteRepository) {
        this.dependenteRepository = dependenteRepository;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Dependente>> buscarTodos() {
        Iterable<Dependente> iterable = dependenteRepository.findAll();
        List<Dependente> dependentes = new ArrayList<>();
        iterable.forEach(dependentes::add);
        return ResponseEntity.ok().body(dependentes);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dependente> criar(@RequestBody Dependente dependente) {
        Dependente novoDependente = dependenteRepository.save(dependente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDependente);
    }
}