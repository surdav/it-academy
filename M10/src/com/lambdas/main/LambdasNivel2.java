package com.lambdas.main;

import com.lambdas.functionalInterfaces.IOperacion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdasNivel2 {

    // Ordenar por longitud (de menor a mayor)
    public static void ordernarPorLongitud(String[] arr) {

        List<String> list = Stream.of(arr)
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());

        System.out.println("Ordenamos Strings por longitud (de menor a mayor)");
        System.out.println(list);
        System.out.println();
    }


    // Ordenamos por longitud (de mayor a menor)
    public static void ordernarPorLongitudInversa(String[] arr) {

        List<String> list = Stream.of(arr)
                .sorted(Comparator.comparing(String::length).reversed())
                .collect(Collectors.toList());

        System.out.println("Ordenamos Strings por longitud (de mayor a menor)");
        System.out.println(list);
        System.out.println();
    }


    // Ordenamos Strings por orden alfabético
    public static void ordenarAlfabeticamente(String[] arr) {

        List<String> list = Stream.of(arr)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Ordenamos Strings alfabéticamente");
        System.out.println(list);
        System.out.println();
    }


    // Las cadenas que contienen 'e' primero, todo lo demás en segundo lugar.
    public static void ordenarPrimeroE(String[] arr) {

        Arrays.sort(arr, (s1, s2) -> {
            if(s1.contains("e") && s2.contains("e")) return 0;
            else if (s1.contains("e")) return -1;
            else return 1;
        });

        System.out.println("Las cadenas que contienen 'e' primero, todo lo demás en segundo lugar");
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }


    // Modifica todos los elementos de la matriz para cambiar los caracteres "a" a "4"
    public static void CambiarAa4(String[] arr) {

        List<String> list = Stream.of(arr)
                .map(s -> s.replaceAll("(?i)a", "4"))
                .collect(Collectors.toList());

        System.out.println("Modificamos todos los elementos de la matriz para cambiar los caracteres 'a' a '4'");
        System.out.println(list);
        System.out.println();
    }


    // Mostramos sólo los elementos que sean 100% numéricos. (Aunque estén guardados como strings)
    public static void filtrarNumeros(String[] arr) {

        List<String> list = Stream.of(arr)
                .filter(s -> s.matches("\\d+"))
                .collect(Collectors.toList());

        System.out.println("Mostramos sólo los elementos que sean 100% numéricos. (Aunque estén guardados como strings)");
        System.out.println(list);
        System.out.println();
    }

    // Operaicions mediante lambdas y Functional Interface
    public static void operacionesConFunctionalInterface() {

        System.out.println("Operaciones mediante lambdas sobre una Functional Interface:");

        IOperacion sumar = Integer::sum;
        IOperacion restar = (numero1, numero2) -> numero1 - numero2;
        IOperacion multiplicar = (numero1, numero2) -> numero1 * numero2;
        IOperacion dividir = (numero1, numero2) -> (float)numero1 / (float)numero2;

        int numero1 = 20;
        int numero2 = 4;

        System.out.printf("Valores: %d y %d\n", numero1, numero2);
        System.out.printf("La suma de los valores: %.0f\n", sumar.operacio(numero1, numero2));
        System.out.printf("La resta de los valores: %.0f\n", restar.operacio(numero1, numero2));
        System.out.printf("El producto de los valores: %.0f\n", multiplicar.operacio(numero1, numero2));
        System.out.printf("El cociente de los valores: %.0f\n", dividir.operacio(numero1, numero2));
        System.out.println();
    }

}
