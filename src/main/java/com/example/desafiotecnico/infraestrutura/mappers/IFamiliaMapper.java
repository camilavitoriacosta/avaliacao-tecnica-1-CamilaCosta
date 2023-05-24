package com.example.desafiotecnico.infraestrutura.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import com.example.desafiotecnico.dominio.entidades.Familia;
import com.example.desafiotecnico.infraestrutura.dtos.FamiliaListaResponseDTO;
import com.example.desafiotecnico.infraestrutura.dtos.FamiliaRequestDTO;
import com.example.desafiotecnico.infraestrutura.dtos.FamiliaResponseDTO;

@Mapper(componentModel = "spring")
public interface IFamiliaMapper {
    public Familia familiaRequestParaFamilia(FamiliaRequestDTO familiaRequestDTO);

    public FamiliaResponseDTO familiaParaFamiliaResponse(Familia familia);

    public Collection<FamiliaResponseDTO> familiasParaFamiliaResponse(List<Familia> familias);

    public FamiliaListaResponseDTO familiaParaFamiliaListaResponse(Familia familia);

    public Collection<FamiliaListaResponseDTO> familiasParaFamiliaListaResponse(List<Familia> familias);
}
