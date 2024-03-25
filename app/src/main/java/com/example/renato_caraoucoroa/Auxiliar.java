package com.example.renato_caraoucoroa;

import android.content.Context;

import java.util.Random;

public class Auxiliar {

    public static String[] jogar(int opcao, Context context) {
        String[] resultado = new String[2];
        int sorteio = sorteio();
        resultado[1] = String.valueOf(selecionaImg(sorteio, context));
        if (opcao == sorteio) {
            resultado[0] = "Você ganhou!";
        } else resultado[0] = "Você perdeu!";
        return resultado;
    }

    private static int sorteio() {
        Random random = new Random();
        return random.nextInt(2); // 0 para cara 1 para coroa
    }

    private static int selecionaImg(int img, Context context) {
        if (img == 0) {
            return R.drawable.cara;
        }
        return R.drawable.coroa;
    }
}
