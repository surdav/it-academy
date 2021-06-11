// M3 Nivell 1 - Fase 4

/*
 * Creeu un nou array de caràcters (char array[])per cada una de les ciutats que tenim.
 * La mida dels nous arrays sera la llargada de cada string ( string nomCiutat.Length).
 *
 * Ompliu els nous arrays lletra per lletra.
 *
 * Mostreu per consola els nous arrays amb els noms invertits (Ex: Barcelona - anolecraB).
 *
 * */

package com.surendavidiants;

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

        String[] stringsArray = {variable1, variable2, variable3, variable4, variable5, variable6};

        for (String el : stringsArray)
            arrayInvertit(el);

    }

    public static void arrayInvertit(String stringAInvertir) {
        char[] charArrayInvertit;
        // Aquí voy a crear un StringBuilder para poder luego invertirlo facil con el método reverse();
        StringBuilder stringBuilder = new StringBuilder();

        /* Aquí con el método append() del StringBuilder convierto el string a invertir al
        StringBuilder. Luego lo vuelvo a convertir al string con el método toString(). En la misma
        * cadena lo convierto al array del tip char con el método toCharArray().
        * */
        charArrayInvertit = stringBuilder.append(stringAInvertir).reverse().toString().toCharArray();

        /*
        * Imprimo el string que representa a la ciudad cancatenando con " - " y con el array del
        * tipo char con el nombre de la ciudad invertida
        */
        System.out.print(stringAInvertir + " - ");
        System.out.println(charArrayInvertit);
    }
}