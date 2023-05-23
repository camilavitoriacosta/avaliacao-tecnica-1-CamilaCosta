package com.example.desafiotecnico.builders;

import java.text.ParseException;
import java.util.Date;

import com.example.desafiotecnico.dtos.PessoaRequestDTO;
import com.example.desafiotecnico.utils.DataConversor;

public class PessoaRequestBuilder {
    private double renda;

    private String nome;

    private Date dataNascimento;

    public PessoaRequestBuilder() throws ParseException {
        renda = 0;
        nome = "Pessoa " + GeradorDeNumero.gerarNumeroInteiroAleatorio(0, 100);
        maiorDeIdade();
    }

    public PessoaRequestDTO construir() {
        return new PessoaRequestDTO(nome, renda, dataNascimento);
    }

    public PessoaRequestBuilder comRenda(double renda) {
        this.renda = renda;
        return this;
    }

    public PessoaRequestBuilder comRendaAleatoria() {
        this.renda = GeradorDeNumero.gerarNumeroDecimalAleatorio(0, 2000);
        return this;
    }

    public PessoaRequestBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaRequestBuilder maiorDeIdade() throws ParseException {
        int dia = GeradorDeNumero.gerarNumeroInteiroAleatorio(1, 28);
        int mes = GeradorDeNumero.gerarNumeroInteiroAleatorio(1, 12);
        int ano = GeradorDeNumero.gerarNumeroInteiroAleatorio(1940, 2003);
        String data = ano + "-" + mes + "-" + dia;

        this.dataNascimento = new DataConversor().converterStringParaDate(data);
        return this;
    }

    public PessoaRequestBuilder menorDeIdade() throws ParseException {
        int dia = GeradorDeNumero.gerarNumeroInteiroAleatorio(1, 28);
        int mes = GeradorDeNumero.gerarNumeroInteiroAleatorio(1, 12);
        int ano = GeradorDeNumero.gerarNumeroInteiroAleatorio(2004, 2023);
        String data = ano + "-" + mes + "-" + dia;

        this.dataNascimento = new DataConversor().converterStringParaDate(data);
        return this;
    }
}
