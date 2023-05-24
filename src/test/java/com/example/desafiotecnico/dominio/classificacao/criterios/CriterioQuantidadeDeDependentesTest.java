package com.example.desafiotecnico.dominio.classificacao.criterios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.desafiotecnico.builders.FamiliaBuilder;
import com.example.desafiotecnico.builders.PessoaBuilder;
import com.example.desafiotecnico.dominio.entidades.Familia;
import com.example.desafiotecnico.dominio.entidades.Pessoa;

public class CriterioQuantidadeDeDependentesTest {
    @Test
    public void nao_deve_pontuar_familia_com_zero_dependentes() {
        Pessoa responsavel = new PessoaBuilder().comRenda(899).construir();
        Familia familia = new FamiliaBuilder().comResponsavel(responsavel).construir();
        ICriterio criterio = new CriterioQuantidadeDeDependentes(1, 2, 2);
        int pontuacaoEsperada = 0;

        int pontuacao = criterio.validar(familia);

        assertEquals(pontuacaoEsperada, pontuacao);
    }

    @Test
    public void deve_validar_familia_com_um_dependente() {
        Pessoa responsavel = new PessoaBuilder().comRenda(899).construir();
        Pessoa dependente = new PessoaBuilder().construir();
        Familia familia = new FamiliaBuilder().comResponsavel(responsavel)
                .comDependente(dependente).construir();
        ICriterio criterio = new CriterioQuantidadeDeDependentes(1, 2, 2);
        int pontuacaoEsperada = 2;

        int pontuacao = criterio.validar(familia);

        assertEquals(pontuacaoEsperada, pontuacao);
    }

    @Test
    public void deve_validar_familia_com_dois_dependentes() {
        Pessoa responsavel = new PessoaBuilder().comRenda(899).construir();
        Pessoa dependente1 = new PessoaBuilder().construir();
        Pessoa dependente2 = new PessoaBuilder().construir();
        Familia familia = new FamiliaBuilder().comResponsavel(responsavel)
                .comDependente(dependente1).comDependente(dependente2).construir();
        ICriterio criterio = new CriterioQuantidadeDeDependentes(1, 2, 2);
        int pontuacaoEsperada = 2;

        int pontuacao = criterio.validar(familia);

        assertEquals(pontuacaoEsperada, pontuacao);
    }

    @Test
    public void nao_deve_pontuar_familia_com_dois_dependentes() {
        Pessoa responsavel = new PessoaBuilder().comRenda(899).construir();
        Pessoa dependente1 = new PessoaBuilder().construir();
        Pessoa dependente2 = new PessoaBuilder().construir();
        Pessoa dependente3 = new PessoaBuilder().construir();
        Familia familia = new FamiliaBuilder().comResponsavel(responsavel)
                .comDependente(dependente1).comDependente(dependente2).comDependente(dependente3).construir();
        ICriterio criterio = new CriterioQuantidadeDeDependentes(1, 2, 2);
        int pontuacaoEsperada = 0;

        int pontuacao = criterio.validar(familia);

        assertEquals(pontuacaoEsperada, pontuacao);
    }

    @Test
    public void nao_considerar_dependentes_menores_de_idade() {
        Pessoa responsavel = new PessoaBuilder().comRenda(899).construir();
        Pessoa dependente = new PessoaBuilder().menorDeIdade().construir();
        Familia familia = new FamiliaBuilder().comResponsavel(responsavel)
                .comDependente(dependente).construir();
        ICriterio criterio = new CriterioQuantidadeDeDependentes(1, 2, 2);
        int pontuacaoEsperada = 0;

        int pontuacao = criterio.validar(familia);

        assertEquals(pontuacaoEsperada, pontuacao);
    }
}
