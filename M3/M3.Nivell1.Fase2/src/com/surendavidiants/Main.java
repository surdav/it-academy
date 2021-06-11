// M3 Nivell 1 - Fase 2

/*
 * Un cop tenim els noms de les ciutats guardats en variables haurem de pasar
 * l’informacio a un array (arrayCiutats).
 *
 * Quan tinguem l’array ple, haurem de mostrar per consola el nom de les ciutats
 * ordenadas per ordre alfabetic.
 *
 * */

package com.surendavidiants;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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

        String[] arr = {variable1, variable2, variable3, variable4, variable5, variable6};

        Arrays.sort(arr);

        for(String el : arr)
            System.out.println(el);
    }
}