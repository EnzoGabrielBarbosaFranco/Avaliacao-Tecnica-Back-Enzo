package com.desafio.digix.repository;

import org.springframework.data.repository.CrudRepository;

import com.desafio.digix.models.Dependente;

import java.util.List;

public interface DependenteRepository extends CrudRepository<Dependente, Long> {
    List<Dependente> findByNomeContaining(String nome);
}
