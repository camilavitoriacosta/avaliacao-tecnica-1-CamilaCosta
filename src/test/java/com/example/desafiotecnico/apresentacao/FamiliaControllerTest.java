package com.example.desafiotecnico.apresentacao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.desafiotecnico.DesafioTecnicoApplication;
import com.example.desafiotecnico.builders.FamiliaBuilder;
import com.example.desafiotecnico.builders.FamiliaRequestDTOBuilder;
import com.example.desafiotecnico.dominio.entidades.Familia;
import com.example.desafiotecnico.dtos.FamiliaListaResponseDTO;
import com.example.desafiotecnico.dtos.FamiliaRequestDTO;
import com.example.desafiotecnico.dtos.FamiliaResponseDTO;
import com.example.desafiotecnico.infraestrutura.FamiliaRepository;
import com.example.desafiotecnico.mappers.FamiliaMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = DesafioTecnicoApplication.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class FamiliaControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private FamiliaRepository familiaRepository;

    @Autowired
    private FamiliaMapper familiaMapper;

    void deve_criar_uma_familia() throws Exception {
        FamiliaRequestDTO familiaRequestDTO = new FamiliaRequestDTOBuilder().construir();
        Long idEsperado = 1L;

        MvcResult resultado = mvc.perform(post("/api/v1/familias/", familiaRequestDTO)).andReturn();

        int status = resultado.getResponse().getStatus();
        String content = resultado.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        FamiliaResponseDTO familiaRetornada = objectMapper.readValue(content, FamiliaResponseDTO.class);

        assertEquals(HttpStatus.OK.value(), status);
        assertThat(idEsperado).isEqualTo(familiaRetornada.getId());
    }

    @Test
    void deve_trazer_familias_ordenadas_por_pontuacao() throws Exception {
        Familia familia1 = new FamiliaBuilder().comPontuacao(5).construir();
        Familia familia2 = new FamiliaBuilder().comPontuacao(3).construir();
        Familia familia3 = new FamiliaBuilder().comPontuacao(8).construir();
        familiaRepository.save(familia2);
        familiaRepository.save(familia1);
        familiaRepository.save(familia3);

        List<FamiliaListaResponseDTO> familiasOrdenadasEsperadas = new ArrayList<>();
        familiasOrdenadasEsperadas.add(familiaMapper.familiaParaFamiliaListaResponse(familia3));
        familiasOrdenadasEsperadas.add(familiaMapper.familiaParaFamiliaListaResponse(familia1));
        familiasOrdenadasEsperadas.add(familiaMapper.familiaParaFamiliaListaResponse(familia2));

        MvcResult resultado = mvc.perform(get("/api/v1/familias/")).andReturn();

        int status = resultado.getResponse().getStatus();
        String content = resultado.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<FamiliaListaResponseDTO> familiasOrdenadas = objectMapper.readValue(content,
                new TypeReference<List<FamiliaListaResponseDTO>>() {
                });

        assertEquals(HttpStatus.OK.value(), status);
        assertThat(familiasOrdenadas).hasSize(familiasOrdenadasEsperadas.size());

        for (int i = 0; i < familiasOrdenadasEsperadas.size(); i++) {
            FamiliaListaResponseDTO familiaEsperada = familiasOrdenadasEsperadas.get(i);
            FamiliaListaResponseDTO familiaAtual = familiasOrdenadas.get(i);
            assertThat(familiaAtual.getId()).isEqualTo(familiaEsperada.getId());
        }
    }
}
