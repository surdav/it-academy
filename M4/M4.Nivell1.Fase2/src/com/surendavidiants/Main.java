package com.surendavidiants;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
// M4 Nivell 1 - Fase 2

        /*
         * Haurem d’omplir els dos arrays anteriorment creats, afegint el nom del plat i després el preu.
         * Es pot fer de dues formes: Es pot fer us d'un diccionari de dades precarregat (Java HashMap) o
         * amb un bucle demanant les dades a l'usuari.
         *
         * Un cop plens els dos arrays haurem de mostrar-los i preguntar que es vol per menjar, guardarem la
         * informació en una List.
         *
         * Haurem de preguntar si es vol seguir demanant menjar. Podeu fer servir el sistema (1:Si / 0:No),
         * per tant haureu de crear un altre variable int per guardar la informació.
         *
         * */
        HashMap<String, Integer> preuPlat = new HashMap<>();
        int seguirPidiendo;
        int precioTotal = 0;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Cuantos platos quieres añadir a la carta?");

            int cantidadPlatos = input.nextInt();
            input.nextLine();

            System.out.println("Introduzca " + cantidadPlatos + " plato(s) con sus correspondientes precios");
            Thread.sleep(1000);
            for (int i = 0, j = 1; i < cantidadPlatos; i++, j++) {
                System.out.println("Introduzca el nombre del plato nº " + j);
                String plats = input.nextLine();

                System.out.println("Cuál es el precio de " + plats + "?");
                int preus = input.nextInt();
                input.nextLine();

                preuPlat.put(plats, preus);
            }
            System.out.println("Quieres seguir pidiendo comida? Pulsa 1 para Sí o 0 parar No!");
            seguirPidiendo = input.nextInt();
        } while (seguirPidiendo == 1);

            System.out.println("Has creado la siguiente carta del restaurante:");

            int platoNum = 1;
            for(Map.Entry<String, Integer> entry : preuPlat.entrySet()){
                System.out.println(platoNum + ". " + entry.getKey() + " ........ precio: " + entry.getValue());
                platoNum++;
            }

            System.out.println("Cuántos platos quieres comer?");
            int cantidadPlatosDeseados = input.nextInt();
            input.nextLine();

            if(cantidadPlatosDeseados <= preuPlat.size())
                System.out.println("Escribe " + cantidadPlatosDeseados + " plato(s) (1 plato por línea) que quieres comer:");
            else{
                System.out.println("Has escogido más platos que hay en la carta");
                return;
            }

            for (int i = 0; i < cantidadPlatosDeseados; i++) {
                String platoDeseado = input.nextLine();
                precioTotal += preuPlat.get(platoDeseado);
            }

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
        System.out.println("Tienes que pagar con el/los siguiente(s) billete(s) o moneda(s):");
        for (int i = 0; i < 9; i++) {
            if (contadorBilletes[i] != 0) {
                System.out.println("€" + billetes[i] + " : "
                        + contadorBilletes[i]);
            }
        }
    }
}