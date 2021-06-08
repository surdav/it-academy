package com.surendavidiants;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // M2 Nivell 2

        /*
        * Crea una aplicació que dibuixi una escala de nombres, sent cada línia nombres
        * començant en un i acabant en el nombre de la línia. Aquest és un exemple,
        * */
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escriu una alçada de l'escala:");
        int alcada = entrada.nextInt();
        escalaNombres(alcada);
    }

    private static void escalaNombres(int nombre){
        for(int i = 1; i <= nombre; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(j);

            System.out.println();
        }
    }
}
