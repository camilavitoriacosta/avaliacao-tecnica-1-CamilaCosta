package com.example.desafiotecnico.dtos;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PessoaRequestDTO {
    private String nome;

    private double renda;

    private Date dataDeNascimento;

    public PessoaRequestDTO(String nome, double renda, Date dataDeNascimento) {
        this.nome = nome;
        this.renda = renda;
        this.dataDeNascimento = dataDeNascimento;
    }
}
