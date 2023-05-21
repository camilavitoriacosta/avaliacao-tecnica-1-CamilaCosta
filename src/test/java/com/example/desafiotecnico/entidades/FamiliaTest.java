package com.example.desafiotecnico.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.desafiotecnico.builders.PessoaBuilder;
import com.example.desafiotecnico.dominio.entidades.Familia;
import com.example.desafiotecnico.dominio.entidades.Pessoa;

public class FamiliaTest {
    @Test
    void deve_poder_criar_uma_familia() throws ParseException {
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