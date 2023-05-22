package com.example.desafiotecnico.apresentacao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiotecnico.aplicacao.FamiliaService;
import com.example.desafiotecnico.dtos.FamiliaListaResponseDTO;
import com.example.desafiotecnico.dtos.FamiliaRequestDTO;
import com.example.desafiotecnico.dtos.FamiliaResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = { "/api/v1/familias" }, produces = { "application/json" })
public class FamiliaController {
    @Autowired
    private FamiliaService familiaService;

    @Operation(summary = "Obter listagem ordenada descrescente por pontuação de familias participantes")
    @ApiResponse(responseCode = "200")
    @GetMapping()
    public ResponseEntity<Collection<FamiliaListaResponseDTO>> obterFamiliasOrdenadasPorPontuacao() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(familiaService.ordenarFamiliasPorPontuacao());
    }

    @Operation(summary = "Cadastrar uma nova familia")
    @ApiResponse(responseCode = "201")
    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<FamiliaResponseDTO> criarFamilia(@RequestBody FamiliaRequestDTO novaFamilia) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(familiaService.criar(novaFamilia));
    }

}
