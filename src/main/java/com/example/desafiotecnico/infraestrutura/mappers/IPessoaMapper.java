package com.example.desafiotecnico.infraestrutura.mappers;

import java.util.Collection;

import org.mapstruct.Mapper;

import com.example.desafiotecnico.dominio.entidades.Pessoa;
import com.example.desafiotecnico.infraestrutura.dtos.PessoaRequestDTO;
import com.example.desafiotecnico.infraestrutura.dtos.PessoaResponseDTO;

@Mapper(componentModel = "spring")
public interface IPessoaMapper {
    public Pessoa pessoaRequestParaPessoa(PessoaRequestDTO pessoaRequestDTO);

    public Collection<Pessoa> pessoasRequestParaPessoas(Collection<PessoaRequestDTO> dependentes);

    public PessoaResponseDTO pessoaParaPessoaResponse(Pessoa pessoa);

    public Collection<PessoaResponseDTO> pessoasParaPessoaResponses(Collection<Pessoa> pessoa);
}
