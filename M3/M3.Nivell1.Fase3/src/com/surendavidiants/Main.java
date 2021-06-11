// M3 Nivell 1 - Fase 3

/*
 * Cambieu les vocals “a” dels noms de les ciutats per el numero 4 i guardeu els noms
 * modificats en un nou array(ArrayCiutatsModificades).
 *
 * Mostreu per consola l’array modificat i ordenat per ordre alfabetic.
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

        String[] ArrayCiutatsModificades = String.join(" ", arr).replace('a', '4').split(" ");

        Arrays.sort(ArrayCiutatsModificades);

        System.out.println("Ciutats modificats per ordre alfabètic:");
        for(String el : ArrayCiutatsModificades)
            System.out.println(el);
    }
}