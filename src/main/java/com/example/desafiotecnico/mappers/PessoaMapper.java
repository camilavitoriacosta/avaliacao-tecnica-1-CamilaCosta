package com.example.desafiotecnico.mappers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import com.example.desafiotecnico.dominio.entidades.Pessoa;
import com.example.desafiotecnico.dtos.PessoaRequestDTO;
import com.example.desafiotecnico.dtos.PessoaResponseDTO;

@Component
public class PessoaMapper implements IPessoaMapper {

    @Override
    public Pessoa pessoaRequestParaPessoa(PessoaRequestDTO pessoaRequestDTO) {
        return new Pessoa(pessoaRequestDTO.getNome(), pessoaRequestDTO.getRenda(),
                pessoaRequestDTO.getDataDeNascimento());
    }

    @Override
    public Collection<Pessoa> pessoasRequestParaPessoas(Collection<PessoaRequestDTO> pessoas) {
        Collection<Pessoa> pessoasMapeados = new ArrayList<Pessoa>();
        for (PessoaRequestDTO pessoa : pessoas) {
            pessoasMapeados.add(pessoaRequestParaPessoa(pessoa));
        }

        return pessoasMapeados;
    }

    @Override
    public PessoaResponseDTO pessoaParaPessoaResponse(Pessoa pessoa) {
        return new PessoaResponseDTO(pessoa.getId(), pessoa.getNome(), pessoa.getRenda(), pessoa.getDataDeNascimento());
    }

    @Override
    public Collection<PessoaResponseDTO> pessoasParaPessoaResponses(Collection<Pessoa> pessoas) {
        Collection<PessoaResponseDTO> pessoasMapeados = new ArrayList<PessoaResponseDTO>();
        for (Pessoa pessoa : pessoas) {
            pessoasMapeados.add(pessoaParaPessoaResponse(pessoa));
        }

        return pessoasMapeados;
    }

}
