package com.example.desafiotecnico.infraestrutura.dtos;

import java.util.Collection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class FamiliaResponseDTO {

    private Long id;

    private PessoaResponseDTO responsavel;

    private PessoaResponseDTO conjugue;

    private Collection<PessoaResponseDTO> dependentes;

    public FamiliaResponseDTO(Long id, PessoaResponseDTO responsavel, PessoaResponseDTO conjugue,
            Collection<PessoaResponseDTO> dependentes) {
        this.id = id;
        this.responsavel = responsavel;
        this.conjugue = conjugue;
        this.dependentes = dependentes;
    }
}
