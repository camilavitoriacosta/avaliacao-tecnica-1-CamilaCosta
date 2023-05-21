package com.example.desafiotecnico.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.desafiotecnico.dominio.entidades.Familia;
import com.example.desafiotecnico.dominio.entidades.Pessoa;
import com.example.desafiotecnico.dtos.FamiliaListaResponseDTO;
import com.example.desafiotecnico.dtos.FamiliaRequestDTO;
import com.example.desafiotecnico.dtos.FamiliaResponseDTO;
import com.example.desafiotecnico.dtos.PessoaResponseDTO;

@Component
public class FamiliaMapper implements IFamiliaMapper {

    @Autowired
    private IPessoaMapper pessoaMapper;

    public Familia familiaRequestParaFamilia(FamiliaRequestDTO familiaRequestDTO) {
        Pessoa responsavel = pessoaMapper.pessoaRequestParaPessoa(familiaRequestDTO.getResponsavel());
        Pessoa conjugue = pessoaMapper.pessoaRequestParaPessoa(familiaRequestDTO.getConjugue());
        Collection<Pessoa> dependentes = pessoaMapper.pessoasRequestParaPessoas(familiaRequestDTO.getDependentes());

        return new Familia(responsavel, conjugue, dependentes);
    }

    @Override
    public FamiliaResponseDTO familiaParaFamiliaResponse(Familia familia) {
        PessoaResponseDTO responsavel = pessoaMapper.pessoaParaPessoaResponse(familia.getResponsavel());
        PessoaResponseDTO conjugue = pessoaMapper.pessoaParaPessoaResponse(familia.getConjugue());
        Collection<PessoaResponseDTO> dependentes = pessoaMapper.pessoasParaPessoaResponses(familia.getDependentes());

        return new FamiliaResponseDTO(familia.getId(), responsavel, conjugue, dependentes);
    }

    @Override
    public Collection<FamiliaResponseDTO> familiasParaFamiliaResponse(List<Familia> familias) {
        Collection<FamiliaResponseDTO> familiasMapeadas = new ArrayList<>();
        for (Familia familia : familias) {
            familiasMapeadas.add(familiaParaFamiliaResponse(familia));
        }
        return familiasMapeadas;
    }

    @Override
    public FamiliaListaResponseDTO familiaParaFamiliaListaResponse(Familia familia) {
        return new FamiliaListaResponseDTO(familia.getId(), familia.getPontuacao());
    }

    @Override
    public Collection<FamiliaListaResponseDTO> familiasParaFamiliaListaResponse(List<Familia> familias) {
        Collection<FamiliaListaResponseDTO> familiasMapeadas = new ArrayList<>();
        for (Familia familia : familias) {
            familiasMapeadas.add(familiaParaFamiliaListaResponse(familia));
        }
        return familiasMapeadas;
    }
}
