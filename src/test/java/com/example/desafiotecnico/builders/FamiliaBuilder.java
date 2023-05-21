package com.example.desafiotecnico.builders;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.desafiotecnico.dominio.entidades.Familia;
import com.example.desafiotecnico.dominio.entidades.Pessoa;

public class FamiliaBuilder {
    private static int MAX_DEPENDENTES = 7;
    private Pessoa responsavel;
    private Pessoa conjugue;
    private Collection<Pessoa> dependentes = new ArrayList<>();
    private int pontuacao = 0;

    public Familia construir() throws ParseException {
        if (responsavel == null) {
            responsavel = new PessoaBuilder().construir();
        }
        if (conjugue == null) {
            conjugue = new PessoaBuilder().construir();
        }
        if (dependentes.size() == 0) {
            int numDependentes = GeradorDeNumero.gerarNumeroInteiroAleatorio(0, MAX_DEPENDENTES + 1);

            List<Pessoa> dependentes = new ArrayList<>();
            for (int i = 0; i < numDependentes; i++) {
                Pessoa dependente = new PessoaBuilder().construir();
                dependentes.add(dependente);
            }
        }

        Familia familia = new Familia(responsavel, conjugue, dependentes);
        familia.setPontuacao(pontuacao);

        return familia;
    }

    public FamiliaBuilder comResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
        return this;
    }

    public FamiliaBuilder comConjugue(Pessoa conjugue) {
        this.conjugue = conjugue;
        return this;
    }

    public FamiliaBuilder comDependente(Pessoa dependente) {
        this.dependentes.add(dependente);
        return this;
    }

    public FamiliaBuilder comPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
        return this;
    }
}
