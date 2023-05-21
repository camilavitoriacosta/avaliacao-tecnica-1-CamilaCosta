package com.example.desafiotecnico.mappers;

import java.util.Collection;

import org.mapstruct.Mapper;

import com.example.desafiotecnico.dominio.entidades.Pessoa;
import com.example.desafiotecnico.dtos.PessoaRequestDTO;
import com.example.desafiotecnico.dtos.PessoaResponseDTO;

@Mapper(componentModel = "spring")
public interface IPessoaMapper {
    public Pessoa pessoaRequestParaPessoa(PessoaRequestDTO pessoaRequestDTO);

    public Collection<Pessoa> pessoasRequestParaPessoas(Collection<PessoaRequestDTO> dependentes);

    public PessoaResponseDTO pessoaParaPessoaResponse(Pessoa pessoa);

    public Collection<PessoaResponseDTO> pessoasParaPessoaResponses(Collection<Pessoa> pessoa);
}
