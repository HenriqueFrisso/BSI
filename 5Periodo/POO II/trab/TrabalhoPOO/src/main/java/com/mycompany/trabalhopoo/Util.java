
package com.mycompany.trabalhopoo;

import java.util.Random;

public class Util {
    public static String gerarCodigo(int tamanho) {
        Random random = new Random();
        StringBuilder sequencia = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            int digito = random.nextInt(10); // Gera um número entre 0 e 9
            sequencia.append(digito);
        }
        return sequencia.toString();
    }
}
