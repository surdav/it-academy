package com.lambdas.main;

import com.lambdas.domain.Alumne;

import java.util.Arrays;
import java.util.List;

import static com.lambdas.main.LambdasNivel1.*;
import static com.lambdas.main.LambdasNivel2.*;
import static com.lambdas.main.LambdasNivel3.*;

public class Main {
    public static void main(String[] args) {
        // Nivell 1. Fase 1. sub-tasca 1
        lamdaUno();


        // Nivell 1. Fase 1. sub-tasca 2
        lamdaDos();


        // Nivell 1. Fase 1. sub-tasca 3
        lamdaTres();


        // Nivell 1. Fase 1. sub-tasca 4
        lamdaCuatro();


        // Nivell 1. Fase 1. sub-tasca 5
        lamdaCinco();


        // Nivell 1. Fase 1. sub-tasca 6
        lamdaSeis();


        // Nivell 1. Fase 2
        lamdaSiete();


        // Nivell 1. Fase 3
        lamdaOcho();


        // Nivel 2
        // Declaramos una matriz con Strings y números
        System.out.println("Nivel 2.");
        String[] matriz = {"Coches", "27", "Motos", "55", "Aviones", "30", "Tractores", "18", "Bicicletas"};
        System.out.println("Array original: " + Arrays.toString(matriz));
        System.out.println();

        // Ordenamos por longitud (de menor a mayor)
        ordernarPorLongitud(matriz);

        // Ordenamos por longitud (de mayor a menor)
        ordernarPorLongitudInversa(matriz);

        // Ordenamos Strings por orden alfabético
        ordenarAlfabeticamente(matriz);

        // Las cadenas que contienen 'e' primero, todo lo demás en segundo lugar.
        ordenarPrimeroE(matriz);

        // Modificamos todos los elementos de la matriz para cambiar los caracteres 'a' a '4'
        CambiarAa4(matriz);

        // Mostramos solo los elementos que sean 100% numéricos. (Aunque estén guardados como strings)
        filtrarNumeros(matriz);

        // Operaicions mediante lambdas y Functional Interface
        operacionesConFunctionalInterface();


        // Nivel 3
        // Omplem la llista amb 10 alumnes
        List<Alumne> alumnes = Arrays.asList(
                new Alumne("Paco", 24, "PHP", 8.0f),
                new Alumne("Pedro", 35, "CLOJURE", 2.2f),
                new Alumne("Jose", 25, "CLOJURE", 9.2f),
                new Alumne("Ramon", 36, "JAVA", 5.2f),
                new Alumne("Andrea", 46, "ANGULAR", 9.1f),
                new Alumne("Jordi", 26, "REACT", 7.1f),
                new Alumne("Teresa", 16, "C++", 4.9f),
                new Alumne("Fran", 56, "C++", 9.9f),
                new Alumne("Maria", 33, "PHP", 3.3f),
                new Alumne("Luis", 44, "GO", 10.0f)
                );

        // Mostrem per pantalla el nom i l’edat de cada alumne.
        imprimirNombreYEdad(alumnes);

        // Filtrem la llista per tots els alumnes que el nom comenci per “A”
        filtrarPorLetraInicial(alumnes, 'A');


        // Filtrem i mostrem per pantalla els alumnes que tinguin un 5 o mes de nota.
        filtrarPorNota(alumnes, 5);


        // Filtrem i mostrem per pantalla els alumnes que tinguin un 5 o mes de nota i
        // que no siguin de PHP.
        filtrarPorNotaYPorCurso(alumnes, 5, "PHP");


        // Mostrem tots els alumnes que facin JAVA i siguin majors d’edat.
        filtrarPorEdadYPorCurso(alumnes, 18, "JAVA");
    }
}