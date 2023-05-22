package com.example.desafiotecnico.aplicacao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafiotecnico.dominio.classificacao.Classificador;
import com.example.desafiotecnico.dominio.classificacao.criterios.ICriterio;
import com.example.desafiotecnico.dominio.entidades.Familia;

@Service
public class ClassificadorFamiliaService {

    @Autowired
    private Classificador classificador;

    public int classificar(Familia familia) {
        Collection<ICriterio> criterios = classificador.obterCriteriosClassificacao();
        int pontuacao = 0;
        for (ICriterio criterio : criterios) {
            pontuacao += criterio.validar(familia);
        }
        return pontuacao;
    }

}
