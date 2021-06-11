package com.surendavidiants;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // M3 Nivell 1 - Fase 1

        /*
        * Crea sis variables tipu string buides.
        * Demana per consola que s’introdueixin els noms.
        * Introdueix els següents noms de ciutats (Barcelona, Madrid, Valencia, Malaga,
        * Cadis, Santander) per teclat.
        * Mostra per consola el nom de les 6 ciutats.
        * */

        String variable1, variable2, variable3, variable4, variable5, variable6;
        Scanner input = new Scanner(System.in);

        System.out.println("Introdueix els següents noms de ciutats (Barcelona, Madrid," +
                " Valencia, Malaga, Cadis, Santander)");
        variable1 = input.nextLine();
        variable2 = input.nextLine();
        variable3 = input.nextLine();
        variable4 = input.nextLine();
        variable5 = input.nextLine();
        variable6 = input.nextLine();

        System.out.println(variable1 + ", " + variable2 + ", " + variable3 + ", " + variable4 +
                ", " + variable5 + ", " + variable6);
    }
}