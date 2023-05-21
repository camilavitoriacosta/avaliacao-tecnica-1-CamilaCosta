package com.example.desafiotecnico.builders;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import com.example.desafiotecnico.dtos.FamiliaRequestDTO;
import com.example.desafiotecnico.dtos.PessoaRequestDTO;

public class FamiliaRequestDTOBuilder {
    private static int MAX_DEPENDENTES = 7;
    private PessoaRequestDTO responsavel;
    private PessoaRequestDTO conjugue;
    private Collection<PessoaRequestDTO> dependentes = new ArrayList<>();

    public FamiliaRequestDTO construir() throws ParseException {
        if (responsavel == null) {
            responsavel = new PessoaRequestBuilder().construir();
        }

        if (conjugue == null) {
            conjugue = new PessoaRequestBuilder().construir();
        }

        if (dependentes.size() == 0) {
            int numDependentes = GeradorDeNumero.gerarNumeroInteiroAleatorio(0, MAX_DEPENDENTES + 1);

            for (int i = 0; i < numDependentes; i++) {
                comDependente(new PessoaRequestBuilder().construir());
            }
        }

        return new FamiliaRequestDTO(responsavel, conjugue, dependentes);
    }

    public FamiliaRequestDTOBuilder comResponsavel(PessoaRequestDTO responsavel) {
        this.responsavel = responsavel;
        return this;
    }

    public FamiliaRequestDTOBuilder comConjugue(PessoaRequestDTO conjugue) {
        this.conjugue = conjugue;
        return this;
    }

    public FamiliaRequestDTOBuilder comDependente(PessoaRequestDTO dependente) {
        this.dependentes.add(dependente);
        return this;
    }
}
