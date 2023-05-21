package com.example.desafiotecnico.dtos;

import java.util.Date;

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

    private Date dataDeNascimento;

    public PessoaResponseDTO(Long id, String nome, double renda, Date dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.renda = renda;
        this.dataDeNascimento = dataDeNascimento;
    }
}
