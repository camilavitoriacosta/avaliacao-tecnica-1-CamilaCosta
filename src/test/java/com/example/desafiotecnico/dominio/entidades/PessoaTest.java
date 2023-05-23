package com.example.desafiotecnico.dominio.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class PessoaTest {

    @Test
    void deve_poder_criar_uma_pessoa() {
        String nome = "Pessoa01";
        int renda = 1000;
        String data = "1970-03-20";
        LocalDate dataConvertida = LocalDate.parse(data);

        Pessoa pessoa = new Pessoa(nome, renda, dataConvertida);

        assertEquals(nome, pessoa.getNome());
        assertEquals(renda, pessoa.getRenda());
        assertEquals(dataConvertida, pessoa.getDataDeNascimento());
    }
}
