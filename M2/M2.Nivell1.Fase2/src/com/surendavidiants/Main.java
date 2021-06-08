package com.surendavidiants;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Nivell 1 - Fase 2

        // Canvia la taula per una llista (List<Character>)
        List<Character> nom = new ArrayList<>();
        nom.add('s');
        nom.add('u');
        nom.add('r');
        nom.add('e');
        nom.add('n');

        // Al bucle, si la lletra és una vocal imprimeix a la consola: ‘VOCAL’.
        // Si nó, imprimeix: ‘CONSONTANT’.
        // Si trobes un numero, mostra per pantalla: ‘Els noms de persones no contenen números!’.

        // Aquí defino el patrón de expresiones regulares que corresponde a los dígitos
        String regexDigits = "\\d+";

        // Aquí defino el patrón de expresiones regulares que corresponde a los vocales
        String regexVocales = "[aeiouAEIOU]";

        for (Character character : nom) {
            if (character.toString().matches(regexVocales))
                System.out.println(character + " VOCAL");

            else if (character.toString().matches(regexDigits))
                System.out.println("Els noms de persones no contenen números!");

            else System.out.println(character + " CONSONTANT");
        }

        /*
        * También se podría comprobar los vocales uno por uno:
        * if (nom.get(i) == 'a' || nom.get(i) == 'e' || nom.get(i) == 'i' || nom.get(i) == 'o' || nom.get(i) == 'u')
        * ..pero con las expresiones regulares resulta menos líneas de código
        *
        * También se podría comprobar los dígitos uno por uno:
        * else if (nom.get(i) == 0 || nom.get(i) == 1 || nom.get(i) == 2 || nom.get(i) == 3 || nom.get(i) == 4 ||
                    nom.get(i) == 5 || nom.get(i) == 6 || nom.get(i) == 7 || nom.get(i) == 8 || nom.get(i) == 9)
        * ..pero el código se hace demasiado largo.
        * */

    }

}