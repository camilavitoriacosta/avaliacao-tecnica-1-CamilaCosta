package com.example.desafiotecnico.aplicacao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.desafiotecnico.builders.FamiliaBuilder;
import com.example.desafiotecnico.builders.PessoaBuilder;
import com.example.desafiotecnico.dominio.entidades.Familia;
import com.example.desafiotecnico.dominio.entidades.Pessoa;

@SpringBootTest
@Transactional
public class ClassificadorFamiliaServiceTest {

    @Autowired
    private ClassificadorFamiliaService classificadorFamiliaService;

    @Test
    void deve_retornar_pontuacao_de_uma_familia_com_renda_ate_900() {
        Pessoa pessoa = new PessoaBuilder().comRenda(900).construir();
        Familia familia = new FamiliaBuilder().comResponsavel(pessoa).construir();
        int pontuacaoEsperada = 5;

        int pontuacaoRetornada = classificadorFamiliaService.classificar(familia);

        assertEquals(pontuacaoEsperada, pontuacaoRetornada);
    }

    @Test
    void deve_retornar_pontuacao_de_uma_familia_com_renda_entre_901_e_1500() {
        Pessoa responsavel = new PessoaBuilder().comRenda(801).construir();
        Pessoa conjugue = new PessoaBuilder().comRenda(100).construir();
        Familia familia = new FamiliaBuilder().comResponsavel(responsavel).comConjugue(conjugue).construir();
        int pontuacaoEsperada = 3;

        int pontuacaoRetornada = classificadorFamiliaService.classificar(familia);

        assertEquals(pontuacaoEsperada, pontuacaoRetornada);
    }
}
