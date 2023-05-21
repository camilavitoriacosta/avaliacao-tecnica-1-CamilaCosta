package com.example.desafiotecnico.dominio.classificacao.criterios;

import com.example.desafiotecnico.dominio.entidades.Familia;

public interface ICriterio {
    int validar(Familia familia);
}
