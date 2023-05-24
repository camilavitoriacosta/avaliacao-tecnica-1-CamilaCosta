package com.example.desafiotecnico.infraestrutura;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.desafiotecnico.builders.PessoaBuilder;
import com.example.desafiotecnico.dominio.entidades.Pessoa;

@DataJpaTest
@Transactional
public class PessoaRepositoryTest {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Test
    void deve_cadastrar_uma_familia() {
        Pessoa pessoa = new PessoaBuilder().construir();

        pessoaRepository.save(pessoa);

        assertNotNull(pessoa.getId());
    }
}
