package com.example.desafiotecnico.builders;

import java.util.ArrayList;
import java.util.Collection;

import com.example.desafiotecnico.dominio.entidades.Familia;
import com.example.desafiotecnico.dominio.entidades.Pessoa;

public class FamiliaBuilder {
    private Pessoa responsavel;
    private Pessoa conjugue;
    private Collection<Pessoa> dependentes = new ArrayList<>();
    private int pontuacao = 0;

    public Familia construir() {
        if (responsavel == null) {
            responsavel = new PessoaBuilder().construir();
        }

        if (conjugue == null) {
            conjugue = new PessoaBuilder().construir();
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
