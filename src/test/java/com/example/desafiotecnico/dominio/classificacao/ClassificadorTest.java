package com.example.desafiotecnico.dominio.classificacao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.desafiotecnico.dominio.classificacao.criterios.CriterioRendaTotal;
import com.example.desafiotecnico.dominio.classificacao.criterios.ICriterio;

public class ClassificadorTest {
    @Test
    public void deve_obter_lista_de_criterios() {
        int tamanhoEsperado = 2;

        List<ICriterio> criteriosRetornados = (List<ICriterio>) new Classificador().obterCriteriosClassificacao();

        assertThat(criteriosRetornados).hasSize(tamanhoEsperado);
        assertThat(criteriosRetornados).element(0).isInstanceOf(CriterioRendaTotal.class);
        assertThat(criteriosRetornados).element(1).isInstanceOf(CriterioRendaTotal.class);
    }
}
