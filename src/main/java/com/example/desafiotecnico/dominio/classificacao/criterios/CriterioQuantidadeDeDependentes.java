package com.example.desafiotecnico.dominio.classificacao.criterios;

import com.example.desafiotecnico.dominio.entidades.Familia;

public class CriterioQuantidadeDeDependentes implements ICriterio {

    private int limiteInferior;
    private int limiteSuperior;
    private int pontuacao;

    public CriterioQuantidadeDeDependentes(int limiteInferior, int limiteSuperior, int pontuacao) {
        this.pontuacao = pontuacao;
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
    }

    public CriterioQuantidadeDeDependentes(int limiteInferior, int pontuacao) {
        this.pontuacao = pontuacao;
        this.limiteInferior = limiteInferior;
    }

    @Override
    public int validar(Familia familia) {
        int dependentesMaioresDeDezoitoAnos = familia.contarDependentesMaioresDeDezoitoAnos();
        if (dependentesMaioresDeDezoitoAnos > 0 && validarLimiteInferior(dependentesMaioresDeDezoitoAnos)
                && validarLimiteSuperior(dependentesMaioresDeDezoitoAnos)) {

            return this.pontuacao;
        }
        return 0;
    }

    private boolean validarLimiteSuperior(int dependentesMaioresDeDezoitoAnos) {
        return limiteSuperior == 0 || dependentesMaioresDeDezoitoAnos <= limiteSuperior;
    }

    private boolean validarLimiteInferior(int dependentesMaioresDeDezoitoAnos) {
        return dependentesMaioresDeDezoitoAnos >= limiteInferior;
    }

}
