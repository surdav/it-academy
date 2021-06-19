package com.surendavidiants;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
// M4 Nivell 2

        /*
         * Revisaràs l'exercici anterior modificant-lo per afegir noves excepcions més adients.
         *
         * Modifica la revisió de la comanda de la següent manera: si un usuari introdueix un plat
         * que no existeix, inmediatament executa una excepció general (new Exception) per avisar
         * que el producte no existeix, per tant no s'ha d'afegir a la llista, però el bucle ha de
         * seguir executant-se.
         *
         * Llança una excepció general (new Exception) a la pregunta Si/No per seguir demanant,
         * en cas de que l'usuari no introdueixi cap de les paraules clau. S'ha de tornar a
         * preguntar si es vol seguir demanant o no.
         *
         * */

        HashMap<String, Integer> preuPlat = new HashMap<>();
        String respuesta = "si";
        int precioTotal = 0;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Cuantos platos quieres añadir a la carta?");

            int cantidadPlatos = input.nextInt();
            if (cantidadPlatos <= 0) return;
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

            while (respuesta.equals("si")) {
                System.out.println("Quieres seguir pidiendo comida? si/no?");
                respuesta = input.nextLine();
                if (respuesta.equals("si"))
                    break;
                else if (respuesta.equals("no")) break;
                else {
                    try {
                        respuesta = "si";
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
                        throw new Exception("Tal plato no existe!");
                    } else {
                        precioTotal += preuPlat.get(platoDeseado);
                        cantidadPlatosDeseados--;
                    }
                } catch (Exception e) {
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