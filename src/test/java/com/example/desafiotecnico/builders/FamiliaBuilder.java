package com.example.desafiotecnico.builders;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.desafiotecnico.dominio.entidades.Familia;
import com.example.desafiotecnico.dominio.entidades.Pessoa;

public class FamiliaBuilder {
    private static int MAX_DEPENDENTES = 7;
    
    public static Familia construir() throws ParseException {
        Random random = new Random();

        Pessoa responsavel = new PessoaBuilder().construir();
        Pessoa conjugue = new PessoaBuilder().construir();
        int numDependentes = random.nextInt(MAX_DEPENDENTES + 1);
       
        List<Pessoa> dependentes = new ArrayList<>();
        for (int i = 0; i < numDependentes; i++) {
            Pessoa dependente = new PessoaBuilder().construir();
            dependentes.add(dependente);
        }

        return new Familia(responsavel, conjugue, dependentes);
    }
}
