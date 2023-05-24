package com.example.desafiotecnico.infraestrutura.dtos;

import java.util.Collection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class FamiliaRequestDTO {

    private PessoaRequestDTO responsavel;

    private PessoaRequestDTO conjugue;

    private Collection<PessoaRequestDTO> dependentes;

    public FamiliaRequestDTO(PessoaRequestDTO responsavel, PessoaRequestDTO conjugue,
            Collection<PessoaRequestDTO> dependentes) {
        this.responsavel = responsavel;
        this.conjugue = conjugue;
        this.dependentes = dependentes;
    }
}
