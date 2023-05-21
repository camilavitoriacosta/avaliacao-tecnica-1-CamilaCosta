package com.example.desafiotecnico.criterios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

import com.example.desafiotecnico.builders.FamiliaBuilder;
import com.example.desafiotecnico.builders.PessoaBuilder;
import com.example.desafiotecnico.dominio.classificacao.criterios.CriterioRendaTotal;
import com.example.desafiotecnico.dominio.classificacao.criterios.ICriterio;
import com.example.desafiotecnico.dominio.entidades.Familia;
import com.example.desafiotecnico.dominio.entidades.Pessoa;

public class CriterioRendaTotalTest {
    @Test
    public void deve_validar_renda_ate_900() throws ParseException {
        Pessoa responsavel = new PessoaBuilder().comRenda(899).construir();
        Familia familia = new FamiliaBuilder().comResponsavel(responsavel).construir();
        ICriterio criterio = new CriterioRendaTotal(0, 900, 5);
        int pontuacaoEsperada = 5;

        int pontuacao = criterio.validar(familia);

        assertEquals(pontuacaoEsperada, pontuacao);
    }
    
    @Test
    public void deve_devolver_zero_pontos_para_renda_igual_a_zero() throws ParseException {
        Pessoa responsavel = new PessoaBuilder().comRenda(0).construir();
        Familia familia = new FamiliaBuilder().comResponsavel(responsavel).construir();
        ICriterio criterio = new CriterioRendaTotal(0, 900, 5);
        int pontuacaoEsperada = 0;

        int pontuacao = criterio.validar(familia);

        assertEquals(pontuacaoEsperada, pontuacao);
    }

    @Test
    public void deve_validar_renda_igual_900() throws ParseException {
        Pessoa responsavel = new PessoaBuilder().comRenda(400).construir();
        Pessoa conjugue = new PessoaBuilder().comRenda(500).construir();
        Familia familia = new FamiliaBuilder().comResponsavel(responsavel).comConjugue(conjugue).construir();
        ICriterio criterio = new CriterioRendaTotal(0, 900, 5);
        int pontuacaoEsperada = 5;

        int pontuacao = criterio.validar(familia);

        assertEquals(pontuacaoEsperada, pontuacao);
    }

    @Test
    public void deve_validar_renda_igual_901() throws ParseException {
        Pessoa responsavel = new PessoaBuilder().comRenda(401).construir();
        Pessoa conjugue = new PessoaBuilder().comRenda(500).construir();
        Familia familia = new FamiliaBuilder().comResponsavel(responsavel).comConjugue(conjugue).construir();
        ICriterio criterio = new CriterioRendaTotal(900, 1500, 3);
        int pontuacaoEsperada = 3;

        int pontuacao = criterio.validar(familia);

        assertEquals(pontuacaoEsperada, pontuacao);
    }
    
    @Test
    public void deve_validar_renda_entre_900_e_1500() throws ParseException {
        Pessoa responsavel = new PessoaBuilder().comRenda(600).construir();
        Pessoa conjugue = new PessoaBuilder().comRenda(500).construir();
        Familia familia = new FamiliaBuilder().comResponsavel(responsavel).comConjugue(conjugue).construir();
        ICriterio criterio = new CriterioRendaTotal(900, 1500, 3);
        int pontuacaoEsperada = 3;

        int pontuacao = criterio.validar(familia);

        assertEquals(pontuacaoEsperada, pontuacao);
    }
}
