package com.example.desafiotecnico.infraestrutura;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.desafiotecnico.builders.FamiliaBuilder;
import com.example.desafiotecnico.dominio.entidades.Familia;

@DataJpaTest
public class FamiliaRepositoryTest {
    @Autowired
    private FamiliaRepository familiaRepository;

    @Test
    void deve_buscar_familias_ordenadas_por_pontuacao() throws ParseException {
        Familia familia1 = new FamiliaBuilder().comPontuacao(5).construir();
        familiaRepository.save(familia1);
        Familia familia2 = new FamiliaBuilder().comPontuacao(3).construir();
        familiaRepository.save(familia2);
        List<Familia> familiasOrdenadasEsperadas = new ArrayList<>();
        familiasOrdenadasEsperadas.add(familia1);
        familiasOrdenadasEsperadas.add(familia2);

        List<Familia> familiasOrdenadas = familiaRepository.findAllOrderByPontuacao();

        assertEquals(familiasOrdenadasEsperadas.size(), familiasOrdenadas.size());

        for (int i = 0; i < familiasOrdenadasEsperadas.size(); i++) {
            Familia familiaEsperada = familiasOrdenadasEsperadas.get(i);
            Familia familiaAtual = familiasOrdenadas.get(i);

            assertEquals(familiaEsperada.getPontuacao(), familiaAtual.getPontuacao());
        }
    }
}