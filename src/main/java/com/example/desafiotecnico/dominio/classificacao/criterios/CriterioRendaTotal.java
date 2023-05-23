package com.example.desafiotecnico.dominio.classificacao.criterios;

import com.example.desafiotecnico.dominio.entidades.Familia;

public class CriterioRendaTotal implements ICriterio {
    private double limiteSuperior;
    private double limiteInferior;
    private int pontuacao;

    public CriterioRendaTotal(double limiteInferior, double limiteSuperior, int pontuacao) {
        this.limiteSuperior = limiteSuperior;
        this.limiteInferior = limiteInferior;
        this.pontuacao = pontuacao;
    }

    @Override
    public int validar(Familia familia) {
        double rendaTotal = familia.obterRendaTotal();
        if (rendaTotal > limiteInferior && rendaTotal <= limiteSuperior) {
            return pontuacao;
        }

        return 0;
    }

}
