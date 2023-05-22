package com.example.desafiotecnico.apresentacao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.desafiotecnico.DesafioTecnicoApplication;
import com.example.desafiotecnico.builders.FamiliaBuilder;
import com.example.desafiotecnico.builders.FamiliaRequestDTOBuilder;
import com.example.desafiotecnico.dominio.entidades.Familia;
import com.example.desafiotecnico.dtos.FamiliaRequestDTO;
import com.example.desafiotecnico.infraestrutura.FamiliaRepository;
import com.example.desafiotecnico.mappers.FamiliaMapper;

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

    // void deve_criar_uma_familia() {
    //     int quantidadeEsperada = 1;
    //     FamiliaRequestDTO familiaRequestDTO = new FamiliaRequestDTOBuilder().construir();

    //     // Action
    //     mvc.perform(post("/api/v1/familias").contentType(MediaType.APPLICATION_JSON)
    //             .content(JsonUtil.toJson(familiaRequestDTO)))
    //             .andExpect(status().isCreated());

    //     // Asserts
    //     Iterable<Familia> tiposEncontrados = familiaRepository.findAll();
    //     long quantidadeEncontrada = tiposEncontrados.spliterator().getExactSizeIfKnown();

    //     assertThat(quantidadeEncontrada).isEqualTo(quantidadeEsperada);
    // }

    @Test
    void deve_trazer_familias_ordenadas_por_pontuacao() throws Exception {
        Familia familia1 = new FamiliaBuilder().comPontuacao(5).construir();
        familiaRepository.save(familia1);
        Familia familia2 = new FamiliaBuilder().comPontuacao(3).construir();
        familiaRepository.save(familia2);
        List<Familia> familiasOrdenadasEsperadas = new ArrayList<>();
        familiasOrdenadasEsperadas.add(familia1);
        familiasOrdenadasEsperadas.add(familia2);

        MvcResult resultado = mvc.perform(get("/api/v1/familias/")).andReturn();

        int status = resultado.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);

        // To-do verificar conteudo da respostas mapeando para json para mapear para a classe familiaReponseDTO
        //String content = resultado.getResponse().getContentAsString();
    }
}
