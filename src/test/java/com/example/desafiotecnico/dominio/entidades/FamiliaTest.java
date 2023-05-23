package com.example.desafiotecnico.dominio.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.desafiotecnico.builders.PessoaBuilder;

public class FamiliaTest {
    @Test
    void deve_poder_criar_uma_familia() {
        Pessoa responsavel = new PessoaBuilder().construir();
        Pessoa conjugue = new PessoaBuilder().construir();
        List<Pessoa> dependentes = new ArrayList<>();
        dependentes.add(new PessoaBuilder().construir());
        dependentes.add(new PessoaBuilder().menorDeIdade().construir());

        Familia familia = new Familia(responsavel, conjugue, dependentes);

        assertEquals(responsavel, familia.getResponsavel());
        assertEquals(conjugue, familia.getConjugue());
        assertEquals(dependentes, familia.getDependentes());
    }
}
