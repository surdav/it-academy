// M3 Nivell 2

/*
 * En aquest exercici crearàs un array bidimensional on introduiràs 3 notes per a 5 alumnes.
 * Es calcularà la nota mitjana de cada alumna i s'indicarà si han suspès o no.
 *
 * Crea un array bidimensional capaç de guardar 3 notes de 5 alumnes.
 * Omple l’array amb un bucle demanant els valors per pantalla (nota entre 0 i 10), has
 * d’identificar per pantalla quan és una agrupació d’un alumne nou.
 * Recorre l'array, fes la Mitjana aritmètica de les 3 notes i indica si l'alumne ha aprovat
 * o suspès.
 *
 * */

package com.surendavidiants;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int entrada;
        int[][] arr = new int[5][3];
        for (int alumnas = 0; alumnas < 5; alumnas++) {
            for (int notas = 0; notas < 3; notas++) {
                System.out.println("Introduce la nota " + (notas + 1) + " para la alumna " + (alumnas + 1));
                entrada = input.nextInt();
                while (entrada < 1 || entrada > 10) {
                    System.out.println("La nota tiene que ser entre 1 y 10");
                    System.out.println("Introduce la nota " + (notas + 1) + " para la alumna " + (alumnas + 1));
                    entrada = input.nextInt();
                }
                arr[alumnas][notas] = entrada;
            }
        }

        float alumna1NotaMedia = (float) (arr[0][0] + arr[0][1] + arr[0][2]) / 3;
        float alumna2NotaMedia = (float) (arr[1][0] + arr[1][1] + arr[1][2]) / 3;
        float alumna3NotaMedia = (float) (arr[2][0] + arr[2][1] + arr[2][2]) / 3;
        float alumna4NotaMedia = (float) (arr[3][0] + arr[3][1] + arr[3][2]) / 3;
        float alumna5NotaMedia = (float) (arr[4][0] + arr[4][1] + arr[4][2]) / 3;

        for (int alumna = 1; alumna <= 5; alumna++){
            float notaMedia;
            if (alumna == 1) notaMedia = alumna1NotaMedia;
            else if (alumna == 2) notaMedia = alumna2NotaMedia;
            else if (alumna == 3) notaMedia = alumna3NotaMedia;
            else if (alumna == 4) notaMedia = alumna4NotaMedia;
            else notaMedia = alumna5NotaMedia;
            if (notaMedia < 5)
                System.out.println("La alumna " + alumna  + " ha suspendido con un " + notaMedia);
            else System.out.println("La alumna " + alumna + " ha aprobado con un " + notaMedia);
        }
    }
}