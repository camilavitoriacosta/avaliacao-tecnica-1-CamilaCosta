package com.example.desafiotecnico.aplicacao;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafiotecnico.dominio.entidades.Familia;
import com.example.desafiotecnico.infraestrutura.FamiliaRepository;
import com.example.desafiotecnico.infraestrutura.dtos.FamiliaListaResponseDTO;
import com.example.desafiotecnico.infraestrutura.dtos.FamiliaRequestDTO;
import com.example.desafiotecnico.infraestrutura.dtos.FamiliaResponseDTO;
import com.example.desafiotecnico.infraestrutura.mappers.IFamiliaMapper;

@Service
public class FamiliaService {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Autowired
    private ClassificadorFamiliaService classificadorFamiliaService;

    @Autowired
    private IFamiliaMapper familiaMapper;

    public FamiliaResponseDTO criar(FamiliaRequestDTO novaFamilia) {
        Familia familia = familiaMapper.familiaRequestParaFamilia(novaFamilia);
        familia.setPontuacao(classificadorFamiliaService.classificar(familia));

        familiaRepository.save(familia);

        return familiaMapper.familiaParaFamiliaResponse(familia);
    }

    public Collection<FamiliaListaResponseDTO> ordenarFamiliasPorPontuacao() {
        List<Familia> familias = familiaRepository.findAllOrderByPontuacao();
        return familiaMapper.familiasParaFamiliaListaResponse(familias);
    }

}
