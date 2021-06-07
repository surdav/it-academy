package com.surendavidiants;

import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {

        // Nivell 1 - Fase 2

        // Sabent que l’any 1948 es un any de traspàs:

        // Creeu una constant amb el valor de l’any (1948).
        final int YEAR = 1948;

        // Creeu una variable que guardi cada quan hi ha un any de traspàs
        int cantitatAnysTraspas = 0;

        // Calculeu quants anys de traspàs hi ha entre 1948 i el vostre any de naixement i
        // emmagatzemeu el valor resultant en una variable.
        // Mostreu per pantalla el resultat del càlcul
        // Feu servir un bucle for, mostrant tots aquests anys

        GregorianCalendar calendar = new GregorianCalendar();
        System.out.println("Anys de traspàs des de 1948 fins 1981:");
        for (int i = YEAR; i <= 1981; i++) {
            if(calendar.isLeapYear(i)){
                cantitatAnysTraspas++;
                System.out.print(i + " ");
            }
        }
        System.out.println("\nNombre d'anys de traspàs des de 1948 fins 1981: " + cantitatAnysTraspas);
    }
}

