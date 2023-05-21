package com.example.desafiotecnico.builders;

import java.util.Random;

public class GeradorDeNumero {
    private static Random random = new Random();

    public static int gerarNumeroInteiroAleatorio(int limiteInferior, int limiteSuperior) {
        return random.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
    }

    public static double gerarNumeroDecimalAleatorio(int limiteInferior, int limiteSuperior) {
        return limiteInferior + (limiteSuperior - limiteInferior) * random.nextDouble();
    }
}
