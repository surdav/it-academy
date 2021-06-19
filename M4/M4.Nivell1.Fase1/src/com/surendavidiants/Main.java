package com.surendavidiants;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
// M4 Nivell 1 - Fase 1

/*
 * L’exercici consisteix a mostrar per consola una carta d’un restaurant on afegirem
 * diferents plats i després escollirem que volem per menjar. Un cop fet això s’haurà
 * de calcular el preu del menjar, i el programa ens dirà amb quins bitllets hem de pagar.
 *
 * - Creeu una variable int per cada un dels bitllets i monedes que existeixen des de 1€ a 500€.
 * Haureu de crear una altra variable per guardar el preu total del menjar.
 *
 * - Creeu dos arrays, un on guardarem el menú i un altre on guardarem el preu de cada plat.
 * */

        String[] plats = {"Patatas fritas", "Patatas bravas", "Spagetti      ", "Paella        ",
                "Arroz negro   ", "Sopa          ", "Calamares     ", "Ensalada      ",
                "Gazpacho      ", "Pezcado      "};

        int[] preus = {8, 12, 6, 14, 13, 7, 9, 5, 4, 15};

        for (int i = 0, j = 1; i < plats.length; i++, j++) {
            System.out.println(j + ". " + plats[i] + "  ........  precio: " + preus[i]);
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Cuántos platos quieres comer?");
        int cantidadPlatosDeseados = input.nextInt();
        input.nextLine();

        if(cantidadPlatosDeseados <= plats.length)
            System.out.println("Escoge " + cantidadPlatosDeseados + " plato(s) (1 por línea) que" +
                    " quieres comer introduciendo el número correspondiente al plato:");
        else{
            System.out.println("Has escogido más platos que hay en la carta");
            return;
        }



        int precioTotal = 0;
        for (int i = 0; i < cantidadPlatosDeseados; i++) {
            precioTotal += preus[(input.nextInt()) - 1];
        }

        input.close();

        System.out.println("Has escogido el menú por un importe de €" + precioTotal);

        CambioBilletes.contarBilletes(precioTotal);
    }
}

class CambioBilletes {


    // función para contar e imprimir billetes
    public static void contarBilletes(int amount) {
        final int FIVE_HUNDRED = 500;
        final int TWO_HUNDRED = 200;
        final int HUNDRED = 100;
        final int FIFTY = 50;
        final int TWENTY = 20;
        final int TEN = 10;
        final int FIVE = 5;
        final int TWO = 2;
        final int ONE = 1;
        int[] billetes = {FIVE_HUNDRED, TWO_HUNDRED, HUNDRED, FIFTY, TWENTY, TEN, FIVE, TWO, ONE};
        int[] contadorBilletes = new int[billetes.length];

        // contar billetes usando el algoritmo voraz
        for (int i = 0; i < billetes.length; i++) {
            if (amount >= billetes[i]) {
                contadorBilletes[i] = amount / billetes[i];
                amount = amount - contadorBilletes[i] * billetes[i];
            }
        }

        // Imprimir billetes / monedas
        System.out.println("Tienes que pagar con el/los siguientes billete(s) o moneda(s):");
        for (int i = 0; i < 9; i++) {
            if (contadorBilletes[i] != 0) {
                System.out.println("€" + billetes[i] + " : "
                        + contadorBilletes[i]);
            }
        }
    }
}