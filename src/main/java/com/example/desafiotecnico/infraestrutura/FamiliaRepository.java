package com.example.desafiotecnico.infraestrutura;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.desafiotecnico.dominio.entidades.Familia;

@Repository
public interface FamiliaRepository extends CrudRepository<Familia, Long> {

    @Query("SELECT f FROM Familia f ORDER BY f.pontuacao DESC")
    List<Familia> findAllOrderByPontuacao();
}
