package com.example.desafiotecnico.infraestrutura.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class FamiliaListaResponseDTO {
    private Long id;
    private int pontuacao;

    public FamiliaListaResponseDTO(Long id, int pontuacao) {
        this.id = id;
        this.pontuacao = pontuacao;
    }
}
