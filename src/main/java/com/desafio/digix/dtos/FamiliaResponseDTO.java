package com.desafio.digix.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FamiliaResponseDTO {
    private int quantidadeDependentes;
    private double renda;
    private String nomeResponsavel;
}