package com.example.desafiotecnico.dominio.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.example.desafiotecnico.utils.DataConversor;

public class PessoaTest {

    @Test
    void deve_poder_criar_uma_pessoa() throws ParseException {
        String nome = "Pessoa01";
        int renda = 1000;
        String data = "1970-03-20";
        Date dataConvertida = new DataConversor().converterStringParaDate(data);

        Pessoa pessoa = new Pessoa(nome, renda, dataConvertida);

        assertEquals(nome, pessoa.getNome());
        assertEquals(renda, pessoa.getRenda());
        assertEquals(dataConvertida, pessoa.getDataDeNascimento());
    }
}
