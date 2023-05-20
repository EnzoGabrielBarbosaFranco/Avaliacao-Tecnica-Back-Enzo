package com.desafio.digix.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.desafio.digix.models.PontuacaoFamilia;

public interface PontuacaoFamiliaRepository extends CrudRepository<PontuacaoFamilia, Long> {
    public List<PontuacaoFamilia> findAll();
}