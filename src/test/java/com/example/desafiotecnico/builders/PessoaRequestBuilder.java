package com.example.desafiotecnico.builders;

import java.time.LocalDate;

import com.example.desafiotecnico.infraestrutura.dtos.PessoaRequestDTO;
import com.example.desafiotecnico.utils.GeradorDeData;
import com.example.desafiotecnico.utils.GeradorDeNumero;

public class PessoaRequestBuilder {
    private double renda;

    private String nome;

    private LocalDate dataNascimento;

    public PessoaRequestBuilder() {
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

    public PessoaRequestBuilder maiorDeIdade() {
        String data = GeradorDeData.gerarDataAleatoria(1940, 2003);
        this.dataNascimento = LocalDate.parse(data);
        return this;
    }

    public PessoaRequestBuilder menorDeIdade() {
        String data = GeradorDeData.gerarDataAleatoria(2004, 2023);
        this.dataNascimento = LocalDate.parse(data);
        return this;
    }
}
