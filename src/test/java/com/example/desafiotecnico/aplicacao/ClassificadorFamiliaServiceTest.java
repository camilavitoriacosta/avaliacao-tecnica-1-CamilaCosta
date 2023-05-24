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

    @Test
    void deve_retornar_pontuacao_de_uma_familia_com_1_dependentes_e_renda_menor_que_900() {
        Pessoa responsavel = new PessoaBuilder().comRenda(800).construir();
        Pessoa conjugue = new PessoaBuilder().comRenda(100).construir();
        Pessoa dependente = new PessoaBuilder().construir();
        Familia familia = new FamiliaBuilder().comResponsavel(responsavel).comConjugue(conjugue)
                .comDependente(dependente).construir();
        int pontuacaoEsperada = 7;

        int pontuacaoRetornada = classificadorFamiliaService.classificar(familia);

        assertEquals(pontuacaoEsperada, pontuacaoRetornada);
    }

    @Test
    void deve_retornar_pontuacao_de_uma_familia_com_2_dependentes_e_renda_menor_que_900() {
        Pessoa responsavel = new PessoaBuilder().comRenda(800).construir();
        Pessoa conjugue = new PessoaBuilder().comRenda(100).construir();
        Pessoa dependente = new PessoaBuilder().construir();
        Pessoa dependente1 = new PessoaBuilder().construir();
        Familia familia = new FamiliaBuilder().comResponsavel(responsavel).comConjugue(conjugue)
                .comDependente(dependente).comDependente(dependente1).construir();
        int pontuacaoEsperada = 7;

        int pontuacaoRetornada = classificadorFamiliaService.classificar(familia);

        assertEquals(pontuacaoEsperada, pontuacaoRetornada);
    }

    @Test
    void deve_retornar_pontuacao_de_uma_familia_com_2_dependentes_e_renda_entre_901_e_1500() {
        Pessoa responsavel = new PessoaBuilder().comRenda(801).construir();
        Pessoa conjugue = new PessoaBuilder().comRenda(100).construir();
        Pessoa dependente = new PessoaBuilder().construir();
        Pessoa dependente1 = new PessoaBuilder().construir();
        Familia familia = new FamiliaBuilder().comResponsavel(responsavel).comConjugue(conjugue)
                .comDependente(dependente).comDependente(dependente1).construir();
        int pontuacaoEsperada = 5;

        int pontuacaoRetornada = classificadorFamiliaService.classificar(familia);

        assertEquals(pontuacaoEsperada, pontuacaoRetornada);
    }

    @Test
    void deve_retornar_pontuacao_de_uma_familia_com_3_dependentes_e_renda_menor_que_900() {
        Pessoa responsavel = new PessoaBuilder().comRenda(800).construir();
        Pessoa conjugue = new PessoaBuilder().comRenda(100).construir();
        Pessoa dependente1 = new PessoaBuilder().construir();
        Pessoa dependente2 = new PessoaBuilder().construir();
        Pessoa dependente3 = new PessoaBuilder().construir();
        Familia familia = new FamiliaBuilder().comResponsavel(responsavel).comConjugue(conjugue)
                .comDependente(dependente1).comDependente(dependente2).comDependente(dependente3).construir();
        int pontuacaoEsperada = 8;

        int pontuacaoRetornada = classificadorFamiliaService.classificar(familia);

        assertEquals(pontuacaoEsperada, pontuacaoRetornada);
    }

    @Test
    void deve_retornar_pontuacao_de_uma_familia_com_3_dependentes_e_renda_entre_901_e_1500() {
        Pessoa responsavel = new PessoaBuilder().comRenda(801).construir();
        Pessoa conjugue = new PessoaBuilder().comRenda(100).construir();
        Pessoa dependente1 = new PessoaBuilder().construir();
        Pessoa dependente2 = new PessoaBuilder().construir();
        Pessoa dependente3 = new PessoaBuilder().comRenda(100).construir();
        Familia familia = new FamiliaBuilder().comResponsavel(responsavel).comConjugue(conjugue)
                .comDependente(dependente1).comDependente(dependente2).comDependente(dependente3).construir();
        int pontuacaoEsperada = 6;

        int pontuacaoRetornada = classificadorFamiliaService.classificar(familia);

        assertEquals(pontuacaoEsperada, pontuacaoRetornada);
    }
}
