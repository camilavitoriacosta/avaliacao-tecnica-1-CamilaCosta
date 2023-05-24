package com.example.desafiotecnico.infraestrutura.dtos;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PessoaResponseDTO {
    private Long id;

    private String nome;

    private double renda;

    private LocalDate dataDeNascimento;

    public PessoaResponseDTO(Long id, String nome, double renda, LocalDate dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.renda = renda;
        this.dataDeNascimento = dataDeNascimento;
    }
}
