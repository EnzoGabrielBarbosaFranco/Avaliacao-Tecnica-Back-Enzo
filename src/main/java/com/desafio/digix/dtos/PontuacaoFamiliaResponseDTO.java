package com.desafio.digix.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PontuacaoFamiliaResponseDTO {
    private int rendaTotal;
    private int numeroDependentes;
}