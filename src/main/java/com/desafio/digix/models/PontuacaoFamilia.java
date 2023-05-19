package com.desafio.digix.models;
import java.util.Arrays;
import java.util.List;

public class PontuacaoFamilia {
    private int rendaTotal;
    private int numeroDependentes;

    public PontuacaoFamilia(int rendaTotal, int numeroDependentes) {
        this.rendaTotal = rendaTotal;
        this.numeroDependentes = numeroDependentes;
    }

    public int calcularPontuacao() {
        int pontuacao = 0;

        if (rendaTotal <= 900) {
            pontuacao += 5;
        } else if (rendaTotal >= 901 && rendaTotal <= 1500) {
            pontuacao += 3;
        }

        int numeroDependentesValidos = Math.max(numeroDependentes - contarDependentesMaioresDe18Anos(), 0);
        
        if (numeroDependentesValidos >= 3) {
            pontuacao += 3;
        } else if (numeroDependentesValidos >= 1 && numeroDependentesValidos <= 2) {
            pontuacao += 2;
        }

        return pontuacao;
    }
    
    private int contarDependentesMaioresDe18Anos() {
        List<Integer> idadesDependentes = Arrays.asList(16, 20, 14, 25, 17);
        
        int contador = 0;
        for (int idade : idadesDependentes) {
            if (idade < 18) {
                contador++;
            }
        }
        
        return contador;
    }

    public static void main(String[] args) {
        PontuacaoFamilia familia1 = new PontuacaoFamilia(800, 4);
        int pontuacao1 = familia1.calcularPontuacao();
        System.out.println("Pontuação da Família 1: " + pontuacao1);

        PontuacaoFamilia familia2 = new PontuacaoFamilia(1200, 2);
        int pontuacao2 = familia2.calcularPontuacao();
        System.out.println("Pontuação da Família 2: " + pontuacao2);
    }
}
