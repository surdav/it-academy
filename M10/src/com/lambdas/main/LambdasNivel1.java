package com.lambdas.main;

import com.lambdas.functionalInterfaces.INumPI;
import com.lambdas.functionalInterfaces.IReverse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdasNivel1 {

    // Nivell 1. Fase 1

    /*  Nivell 1. Fase 1. Sub-tasca 1.

        Tenint una llista de cadenes de noms propis, escriu un mètode que retorne
        una llista de totes les cadenes que comencen amb la lletra 'a' (mayuscula)
        i tenen exactament 3 lletres. Imprimeix el resultat. */

    // filtrem per 2 condicions "AND"
    public static void lamdaUno() {
        List<String> listUno = Arrays.asList("Ana", "Lee" ,"Angelina", "Juan", "Antonia", "Sergio", "Ady", "Bea", "Pedro", "Carla", "Ada");

        List<String> listDos = listUno.stream()
                .filter(str -> str.startsWith("A") && str.length() == 3)
                .collect(Collectors.toList());

        System.out.println("Nivel 1. Fase 1. Sub-tarea 1");
        System.out.println("Array original: " + listUno);
        System.out.println("Nombres que empiezan con A y que tienen 3 letras: " + listDos);
        System.out.println();
    }


    /*  Nivell 1. Fase 1. Sub-tasca 2.

        Escriu un mètode que retorne una cadena separada per comes basada en una llista d’Integers. Cada element hauria d'anar precedit per la lletra "e" si el nombre és parell, i precedit de la lletra "o" si el nombre és imparell. Per exemple, si la llista d'entrada és (3,44), la sortida hauria de ser "o3, e44". Imprimeix el resultat.  */

    // fer acció per 2 condicions
    public static void lamdaDos() {
        List<Integer> listUno = Arrays.asList(1, 2, 3, 4, 5, 11, 22, 33, 44, 55, 10, 20, 30, 40, 50);

        StringBuilder stringBuilder = new StringBuilder();

        listUno.forEach(numero -> {
            if (numero % 2 == 0) stringBuilder.append("e").append(numero);
            else stringBuilder.append("o").append(numero);

            stringBuilder.append(",");
        });

        System.out.println("Nivel 1. Fase 1. Sub-tarea 2");
        System.out.println("Array original: " + listUno);
        System.out.println("Añadimos la letra 'e' a los números pares, y la letra 'o' a los números impares: " + stringBuilder);
        System.out.println();
    }



    /*  Nivell 1. Fase 1. Sub-tasca 3.

        Tenint una llista de Strings, escriu un mètode que retorne una llista de totes les cadenes que continguen la lletra ‘o’ i imprimeix el resultat.   */

    // fer acció per 1 condició
    public static void lamdaTres() {

        List<String> listUno = Arrays.asList("Ana", "Lee" ,"Adelaila", "Juan", "Antonia", "Sergio", "Ady", "Bea", "Pedro", "Carla", "Ada");

        List<String> listDos = listUno.stream()
                .filter(str -> str.contains("o"))
                .collect(Collectors.toList());

        System.out.println("Nivel 1. Fase 1. Sub-tarea 3");
        System.out.println("Array original: " + listUno);
        System.out.println("Devuelve todas las palabras que contienen la letra 'o': " + listDos);
        System.out.println();
    }


    /*  Nivell 1. Fase 1. Sub-tasca 4.

        Has de fer el mateix que en el punt anterior, però retornant una llista que incloga els elements amb més de 5 lletres. Imprimeix el resultat.   */

    // filtrar per 2 condicions "AND"
    public static void lamdaCuatro() {

        List<String> listUno = Arrays.asList("Ana", "Lee" ,"Adelaila", "Juan", "Antonia", "Sergio", "Ady", "Bea", "Pedro", "Carla", "Ada");

        List<String> listDos = listUno.stream()
                .filter(str -> str.contains("o") && str.length() > 5)
                .collect(Collectors.toList());

        System.out.println("Nivel 1. Fase 1. Sub-tarea 4");
        System.out.println("Array original: " + listUno);
        System.out.println("Devuelve todas las palabras que contienen la letra 'o' y que sean de más de 5 letras: " + listDos);
        System.out.println();
    }


    /*  Nivell 1. Fase 1. Sub-tasca 5.

        Crea una llista amb els nombs dels mesos de l’any. Imprimeix tots els elements de la llista amb una lambda.   */

    // imprimeix llista Strings
    public static void lamdaCinco() {

        List<String> listUno = Arrays.asList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");

        System.out.println("Nivel 1. Fase 1. Sub-tarea 5");
        System.out.println("Array original: " + listUno);
        System.out.println("Imprimimos todos los meses mediante una lambda:");
        listUno.forEach(str -> System.out.println(str));
        System.out.println();
    }


    /*  Nivell 1. Fase 1. Sub-tasca 6.

        Has de fer la mateixa impressió del punt anterior però fent-ho mitjançant method reference.   */

    // imprimeix llista Strings amb method reference
    public static void lamdaSeis() {

        List<String> listUno = Arrays.asList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");

        System.out.println("Nivel 1. Fase 1. Sub-tarea 6");
        System.out.println("Array original: " + listUno);
        System.out.println("Imprimimos todos los meses mediante una lambda con method reference:");
        listUno.forEach(System.out::println);
        System.out.println();
    }


    /*  Nivell 1. Fase 2.

        Crea una Functional Interface que continga un mètode abstracte getPiValue (),
        que retorna un valor double; en una altra classe, instancie la interfície i
        assigneu-li mitjançant una lambda el valor 3.1415. Invoca el mètode
        getPiValue de la instància d'interfície i imprimeix el resultat.    */

    // utilitzem lambda en un mètode abstracte sense paràmetre
    public static void lamdaSiete() {

        INumPI pi = () -> 3.1415;

        System.out.println("Nivel 1. Fase 2.");
        System.out.println("Inyectamos mediante una lambda un método a una interfaz funcional que no recibe parámetro");
        System.out.println("Resultado: " + pi.getPiValue());
        System.out.println();
    }


    /*  Nivell 1. Fase 3.

        Crea una Functional Interface que continga un mètode abstracte reverse (),
        que retorne un valor String; en una altra classe, injecta a la interfície
        creada mitjançant una lambda el cos del mètode, de manera que torne la
        mateixa cadena que rep com a paràmetre però a l'inrevés. Invoca la
        instància de la interfície passant-li una cadena i comprovant el resultat.    */

    // utilitzem lambda en un mètode abstracte amb paràmetre
    public static void lamdaOcho() {

        IReverse reverse = (str) -> {
          StringBuilder stringBuilder = new StringBuilder(str);
          return stringBuilder.reverse().toString();
        };

        System.out.println("Nivel 1. Fase 3.");
        System.out.println("Inyectamos mediante lambda un método a una interfaz funcional que recibe un parámetro.");
        System.out.println("La cadena original: 'Hola Java funcional'");
        System.out.println("La misma cadena recibida como parámetro, pero al revés: " + reverse.reverse("Hola Java funcional!"));
        System.out.println();
    }


}
