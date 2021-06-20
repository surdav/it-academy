package com.surendavidiants;

import com.surendavidiants.excepciones.CantidadPlatosNoVacia;
import com.surendavidiants.excepciones.NombrePlatoErroneo;
import com.surendavidiants.excepciones.RevisioTipus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws RevisioTipus,
            CantidadPlatosNoVacia, NombrePlatoErroneo
    {
// M4 Nivell 3

        /*
         * Crea excepcions personalitzades amb fitxers nous e implementa-les al codi actual.
         *
         * - Has de crear Excepcions personalitzades per: Revisió de tipus, introducció de plats,
         *   revisió de plats de la comanda.
         *
         * - El text ha de ser personalitzat. No cal que propaguis l’excepció.
         *
         * - Rodeja amb un try/catch cada part que has de revisar amb una excepció.
         *
         * */

        HashMap<String, Integer> preuPlat = new HashMap<>();
        String respuesta;
        int precioTotal = 0;
        Scanner input = new Scanner(System.in);
        int cantidadPlatos;

        do {
            System.out.println("Cuantos platos quieres añadir a la carta?");

            try {
                    if(input.hasNextInt()) cantidadPlatos = input.nextInt();
                    else throw new RevisioTipus();
            } catch (RevisioTipus e) {
                System.err.println("La entrada tiene que ser numérica");
                return;
            }

            try {
                if (cantidadPlatos <= 0) throw new CantidadPlatosNoVacia();
            } catch (CantidadPlatosNoVacia e) {
                System.err.println("La cantidad de platos escogidos no puede ser negativo o igual a 0!");
                return;
            }

            input.nextLine();

            System.out.println("Introduzca " + cantidadPlatos + " plato(s) con su(s) precio(s) correspondiente(s)");
            for (int i = 0, j = 1; i < cantidadPlatos; i++, j++) {
                System.out.println("Introduzca el nombre del plato nº " + j);
                String plats = input.nextLine();

                System.out.println("Cuál es el precio de " + plats + "?");
                int preus = input.nextInt();
                input.nextLine();

                preuPlat.put(plats, preus);
            }

            while (true) {
                System.out.println("Quieres seguir pidiendo comida? si/no?");
                respuesta = input.nextLine();
                if (respuesta.equals("si"))
                    break;
                else if (respuesta.equals("no")) break;
                else {
                    try {
                        throw new Exception("Elige entre si o no");
                    } catch (Exception e) {
                        System.err.println("¡OJO! La respuesta tiene que ser si o no. Vuelve a escribirlo!");
                    }
                }
            }
        } while (respuesta.equals("si"));

        System.out.println("Has creado la siguiente carta del restaurante:");

        int platoNum = 1;
        for (Map.Entry<String, Integer> entry : preuPlat.entrySet()) {
            System.out.println(platoNum + ". " + entry.getKey() + " ........ precio: €" + entry.getValue());
            platoNum++;
        }

        System.out.println("Cuántos platos quieres comer?");
        int cantidadPlatosDeseados = input.nextInt();
        if (cantidadPlatosDeseados <= 0) return;
        input.nextLine();

        if (cantidadPlatosDeseados <= preuPlat.size())
            System.out.println("Escribe " + cantidadPlatosDeseados + " plato(s) (1 plato por línea) que quieres comer:");
        else {
            System.out.println("Has escogido más platos que hay en la carta");
            return;
        }

        String platoDeseado = null;
        // Con este while seguimos pidiendo al usuario que introduzca el nombre correcto del plato
        while (!preuPlat.containsKey(platoDeseado)) {
            while (cantidadPlatosDeseados > 0) {
                platoDeseado = input.nextLine();
                // Aquí comprobamos si el plato introducido existe en el menú
                try {
                    if (!preuPlat.containsKey(platoDeseado)) {
                        throw new NombrePlatoErroneo();
                    } else {
                        precioTotal += preuPlat.get(platoDeseado);
                        cantidadPlatosDeseados--;
                    }
                } catch (NombrePlatoErroneo e) {
                    System.err.println("¡OJO! Comprueba el nombre del plato y vuelve a escribirlo!");
                }
            }
        }

        if (precioTotal == 0) return;

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
        System.out.println("Tienes que pagar con los siguientes billetes o monedas:");
        for (int i = 0; i < 9; i++) {
            if (contadorBilletes[i] != 0) {
                if (billetes[i] < 5)
                    System.out.println(contadorBilletes[i] + " moneda(s) de €" + billetes[i]);
                else
                    System.out.println(contadorBilletes[i] + " billete(s) de €" + billetes[i]);
            }
        }
    }
}