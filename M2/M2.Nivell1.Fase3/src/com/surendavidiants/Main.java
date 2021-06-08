package com.surendavidiants;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Nivell 1 - Fase 3

        /*
         * Emmagatzemar en un Map tant les lletres de la llista com el nombre de vegades que apareixen.
         * Has de recòrrer l'array anterior i anar comptant el número de vegades que apareix cada caràcter.
         * */

        String nom = "Leo Messi";
        contarCaracteres(nom);
    }

    static void contarCaracteres(String nombre) {
        // Creo un HashMap que contenga char como clave y las repeticiones como valor
        HashMap<Character, Integer> lista = new HashMap<>();

        // Conversión de una string dada en un array de caracteres

        char[] strArray = nombre.toCharArray();

        // Comprobando cada carácter de strArray
        for (char letra : strArray) {
            if (lista.containsKey(letra)) {
                // Si la letra está en la lista, se incrementa su recuento en 1
                lista.put(letra, lista.get(letra) + 1);
            } else {

                // Si la letra no está en la lista, ponemos esta letra en la lista con valor 1
                lista.put(letra, 1);
            }
        }

        // Imprimiendo la lista
        lista.forEach((key, value) -> System.out.println("clau='" + key + "', valor=" + value));
    }
}
