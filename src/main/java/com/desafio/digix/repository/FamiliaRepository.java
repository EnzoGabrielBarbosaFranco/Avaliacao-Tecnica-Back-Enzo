package com.desafio.digix.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.desafio.digix.models.Familia;

public interface FamiliaRepository extends CrudRepository<Familia, Long> {
    public List<Familia> findAll();
}