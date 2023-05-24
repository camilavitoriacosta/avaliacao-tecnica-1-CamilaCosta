package com.example.desafiotecnico.infraestrutura.dtos;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PessoaRequestDTO {
    private String nome;

    private double renda;

    private LocalDate dataDeNascimento;

    public PessoaRequestDTO(String nome, double renda, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.renda = renda;
        this.dataDeNascimento = dataDeNascimento;
    }
}
