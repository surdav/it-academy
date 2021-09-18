package com.lambdas.main;

import com.lambdas.domain.Alumne;

import java.util.List;
import java.util.stream.Collectors;

public class LambdasNivel3 {

    // Mostrem per pantalla el nom i l’edat de cada alumne.
    public static void imprimirNombreYEdad(List<Alumne> alumnes) {

        System.out.println("Nivel 3");
        System.out.println("ArrayList rellenado con los datos de 10 alumnos");
        System.out.println(alumnes);
        System.out.println();
        System.out.println("Mostramos por pantalla el nombre y la edad de cada alumno:");
        alumnes.forEach(a -> System.out.println("Nombre: " + a.getNom() + " , Edad: " + a.getEdad()));
        System.out.println();
    }


    // Filtrem la llista per tots els alumnes que el nom comenci per “A”,
    // asignem-ho a un altre llista y mostrem per pantalla la nova llista
    // (tot amb lambdas)
    public static void filtrarPorLetraInicial(List<Alumne> alumnes, char letra) {

        System.out.println("Filtramos todos los alumnos que comiencen por 'A':");

        List<Alumne> filtroAlumnos = alumnes.stream()
                .filter(a -> a.getNom().charAt(0) == letra)
                .collect(Collectors.toList());

        filtroAlumnos.forEach(a -> System.out.println("Nombre: " + a.getNom() + ", Edad: " + a.getEdad()));

        System.out.println();
    }



    // Filtrem i mostrem per pantalla els alumnes que tinguin un 5 o mes de nota.
    public static void filtrarPorNota(List<Alumne> alumnes, int nota) {

        System.out.println("Filtramos y mostramos por pantalla los alumnos que tengan un 5 o más de nota:");

        alumnes.stream().filter(a -> a.getNota() >= nota)
                .forEach(a -> System.out.println("Nombre: " + a.getNom() + ", Nota: " + a.getNota()));

        System.out.println();
    }


    // Filtrem i mostrem per pantalla els alumnes que tinguin un 5 o mes de nota i
    // que no siguin de PHP.
    public static void filtrarPorNotaYPorCurso(List<Alumne> alumnes, int nota, String curs) {

        System.out.println("Filtramos todos los alumnos con un 5 o más y que no hacen PHP:");
        alumnes.stream()
                .filter(a -> a.getNota() >= nota && !a.getCurs().equals(curs))
                .forEach(a -> System.out.println(
                        "Nombre: " + a.getNom() + ", Nota: " + a.getNota() + ", Curso: " + a.getCurs())
                );

        System.out.println();
    }


    // Mostrem tots els alumnes que facin JAVA i siguin majors d’edat.
    public static void filtrarPorEdadYPorCurso(List<Alumne> alumnes, int edad, String curs) {

        System.out.println("Mostramos todos los alumnos que hagan JAVA y sean mayores de edad:");

        alumnes.stream()
                .filter(a -> a.getEdad() > edad && a.getCurs().equals(curs))
                .forEach(a -> System.out.println(
                        "Nombre: " + a.getNom() + ", Edad: " + a.getEdad() + ", Curso: " + a.getCurs())
                );

        System.out.println();
    }
}
