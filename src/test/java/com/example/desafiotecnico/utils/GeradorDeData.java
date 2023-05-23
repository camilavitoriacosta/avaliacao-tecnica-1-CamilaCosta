package com.example.desafiotecnico.utils;

public class GeradorDeData {
    public static String gerarDataAleatoria(int intervaloDataInicial, int intervaloDataFinal) {
        int dia = GeradorDeNumero.gerarNumeroInteiroAleatorio(1, 28);
        int mes = GeradorDeNumero.gerarNumeroInteiroAleatorio(1, 12);
        int ano = GeradorDeNumero.gerarNumeroInteiroAleatorio(intervaloDataInicial, intervaloDataFinal);
        return ano + "-" + String.format("%02d", mes) + "-" + String.format("%02d", dia);
    }
}
