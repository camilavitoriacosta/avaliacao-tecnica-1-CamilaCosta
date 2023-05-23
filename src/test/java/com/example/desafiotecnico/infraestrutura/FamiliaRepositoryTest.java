package com.example.desafiotecnico.infraestrutura;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.desafiotecnico.builders.FamiliaBuilder;
import com.example.desafiotecnico.dominio.entidades.Familia;

@DataJpaTest
@Transactional
public class FamiliaRepositoryTest {
    @Autowired
    private FamiliaRepository familiaRepository;

    @Test
    void deve_cadastrar_uma_familia() {
        Familia familia = new FamiliaBuilder().construir();

        familiaRepository.save(familia);

        assertNotNull(familia.getId());
    }

    @Test
    void deve_buscar_familias_ordenadas_por_pontuacao() {
        Familia familia2 = new FamiliaBuilder().comPontuacao(3).construir();
        familiaRepository.save(familia2);
        Familia familia1 = new FamiliaBuilder().comPontuacao(5).construir();
        familiaRepository.save(familia1);
        List<Familia> familiasOrdenadasEsperadas = new ArrayList<>();
        familiasOrdenadasEsperadas.add(familia1);
        familiasOrdenadasEsperadas.add(familia2);
        int tamanhoEsperado = familiasOrdenadasEsperadas.size();

        List<Familia> familiasOrdenadas = familiaRepository.findAllOrderByPontuacao();

        assertThat(familiasOrdenadas).hasSize(tamanhoEsperado);

        for (int i = 0; i < tamanhoEsperado; i++) {
            Familia familiaEsperada = familiasOrdenadasEsperadas.get(i);
            Familia familiaAtual = familiasOrdenadas.get(i);

            assertEquals(familiaEsperada.getPontuacao(), familiaAtual.getPontuacao());
        }
    }
}
