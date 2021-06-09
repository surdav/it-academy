package com.surendavidiants;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // M2 Nivell 2b

        /*
         * Crea una aplicació que dibuixi una piràmide invertida de asteriscs.
         * Nosaltres li vam passar l'alçada de la piràmide per teclat.
         * */
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escriu una alçada de la piràmide:");
        int alcada = entrada.nextInt();
        piramideInvertida(alcada);
    }

    public static void piramideInvertida(int altura) {
        for (int i = 0; i <= altura - 1; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= altura - 1 - i; k++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
}
