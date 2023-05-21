package com.example.desafiotecnico.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.example.desafiotecnico.DataConversor;
import com.example.desafiotecnico.dominio.entidades.Pessoa;

public class PessoaTest {

    @Test
    void deve_poder_criar_uma_pessoa() throws ParseException {
        String nome = "Pessoa01";
        int renda = 1000;
        String data = "20/03/1970";
        Date dataConvertida = new DataConversor().converterStringParaDate(data);

        Pessoa pessoa = new Pessoa(nome, renda, dataConvertida);

        assertEquals(nome, pessoa.getNome());
        assertEquals(renda, pessoa.getRenda());
        assertEquals(dataConvertida, pessoa.getDataDeNascimento());
    }
}
