package com.example.desafiotecnico.builders;

import java.time.LocalDate;

import com.example.desafiotecnico.dominio.entidades.Pessoa;
import com.example.desafiotecnico.utils.GeradorDeData;
import com.example.desafiotecnico.utils.GeradorDeNumero;

public class PessoaBuilder {
    private double renda;

    private String nome;

    private LocalDate dataNascimento;

    public PessoaBuilder() {
        renda = 0;
        nome = "Pessoa " + GeradorDeNumero.gerarNumeroInteiroAleatorio(0, 100);
        maiorDeIdade();
    }

    public Pessoa construir() {
        return new Pessoa(nome, renda, dataNascimento);
    }

    public PessoaBuilder comRenda(double renda) {
        this.renda = renda;
        return this;
    }

    public PessoaBuilder comRendaAleatoria() {
        this.renda = GeradorDeNumero.gerarNumeroDecimalAleatorio(0, 2000);
        return this;
    }

    public PessoaBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaBuilder maiorDeIdade() {
        String data = GeradorDeData.gerarDataAleatoria(1940, 2003);
        this.dataNascimento = LocalDate.parse(data);
        return this;
    }

    public PessoaBuilder menorDeIdade() {
        String data = GeradorDeData.gerarDataAleatoria(2004, 2023);
        this.dataNascimento = LocalDate.parse(data);
        return this;
    }
}
