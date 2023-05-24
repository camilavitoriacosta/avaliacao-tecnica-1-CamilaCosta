package com.example.desafiotecnico.dominio.classificacao;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import com.example.desafiotecnico.dominio.classificacao.criterios.CriterioQuantidadeDeDependentes;
import com.example.desafiotecnico.dominio.classificacao.criterios.CriterioRendaTotal;
import com.example.desafiotecnico.dominio.classificacao.criterios.ICriterio;

@Component
public class Classificador {
    private Collection<ICriterio> criterios = new ArrayList<ICriterio>();

    public Classificador() {
        adicionar(new CriterioRendaTotal(0, 900, 5));
        adicionar(new CriterioRendaTotal(900, 1500, 3));
        adicionar(new CriterioQuantidadeDeDependentes(3, 3));
        adicionar(new CriterioQuantidadeDeDependentes(1, 2, 2));
    }

    public Collection<ICriterio> obterCriteriosClassificacao() {
        return this.criterios;
    }

    private void adicionar(ICriterio criterio) {
        this.criterios.add(criterio);
    }
}
