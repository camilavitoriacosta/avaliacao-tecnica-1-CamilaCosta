package com.example.desafiotecnico.builders;

import java.text.ParseException;
import java.util.Date;

import com.example.desafiotecnico.DataConversor;
import com.example.desafiotecnico.dominio.entidades.Pessoa;

public class PessoaBuilder {
    private double renda;

    private String nome;

    private Date dataNascimento;

    public PessoaBuilder() throws ParseException {
        renda = GeradorDeNumero.gerarNumeroDecimalAleatorio(0, 2000);
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

    public PessoaBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaBuilder maiorDeIdade() throws ParseException {
        int dia = GeradorDeNumero.gerarNumeroInteiroAleatorio(1, 28);
        int mes = GeradorDeNumero.gerarNumeroInteiroAleatorio(1, 12);
        int ano = GeradorDeNumero.gerarNumeroInteiroAleatorio(1940, 2003);
        String data = dia + "/" + mes + "/" + ano;

        this.dataNascimento = new DataConversor().converterStringParaDate(data);
        return this;
    }

    public PessoaBuilder menorDeIdade() throws ParseException {
        int dia = GeradorDeNumero.gerarNumeroInteiroAleatorio(1, 28);
        int mes = GeradorDeNumero.gerarNumeroInteiroAleatorio(1, 12);
        int ano = GeradorDeNumero.gerarNumeroInteiroAleatorio(2004, 2023);
        String data = dia + "/" + mes + "/" + ano;

        this.dataNascimento = new DataConversor().converterStringParaDate(data);
        return this;
    }
}