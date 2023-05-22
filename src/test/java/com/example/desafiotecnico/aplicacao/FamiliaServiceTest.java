package com.example.desafiotecnico.aplicacao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.desafiotecnico.builders.FamiliaBuilder;
import com.example.desafiotecnico.builders.FamiliaRequestDTOBuilder;
import com.example.desafiotecnico.dominio.entidades.Familia;
import com.example.desafiotecnico.dtos.FamiliaListaResponseDTO;
import com.example.desafiotecnico.dtos.FamiliaRequestDTO;
import com.example.desafiotecnico.dtos.FamiliaResponseDTO;
import com.example.desafiotecnico.infraestrutura.FamiliaRepository;
import com.example.desafiotecnico.mappers.FamiliaMapper;

@SpringBootTest
public class FamiliaServiceTest {
    @Autowired
    private FamiliaService familiaService;
    @Autowired
    private FamiliaMapper familiaMapper;
    @Autowired
    private FamiliaRepository familiaRepository;

    @Test
    @Transactional
    void deve_salvar_uma_familia() throws Exception {
        FamiliaRequestDTO familiaRequestDTO = new FamiliaRequestDTOBuilder().construir();

        FamiliaResponseDTO response = familiaService.criar(familiaRequestDTO);

        assertThat(response.getId()).isNotNull();
    }

    @Test
    void deve_ordenar_familias_por_pontuacao() throws ParseException {
        Familia familia1 = new FamiliaBuilder().comPontuacao(5).construir();
        familiaRepository.save(familia1);
        Familia familia2 = new FamiliaBuilder().comPontuacao(3).construir();
        familiaRepository.save(familia2);
        List<Familia> familiasOrdenadasEsperadas = new ArrayList<>();
        familiasOrdenadasEsperadas.add(familia1);
        familiasOrdenadasEsperadas.add(familia2);
        List<FamiliaListaResponseDTO> familiasParaFamiliaListaResponse = (List<FamiliaListaResponseDTO>) familiaMapper
                .familiasParaFamiliaListaResponse(familiasOrdenadasEsperadas);

        List<FamiliaListaResponseDTO> response = (List<FamiliaListaResponseDTO>) familiaService
                .ordenarFamiliasPorPontuacao();

        assertEquals(response.size(), familiasParaFamiliaListaResponse.size());

        for (int i = 0; i < familiasOrdenadasEsperadas.size(); i++) {
            FamiliaListaResponseDTO familiaEsperada = response.get(i);
            FamiliaListaResponseDTO familiaAtual = familiasParaFamiliaListaResponse.get(i);

            assertEquals(familiaEsperada.getPontuacao(), familiaAtual.getPontuacao());
        }
    }
}
