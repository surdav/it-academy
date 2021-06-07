package com.surendavidiants;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
		
		// Nivell 1 - Fase 3

		
        final int YEAR = 1948;
        int cantitatAnysTraspas = 0;
        GregorianCalendar calendar = new GregorianCalendar();
        for (int i = YEAR; i <= 1981; i++) {
            if(calendar.isLeapYear(i)){
                cantitatAnysTraspas++;
            }
        }


        // Creeu una variable bool que sera certa si l’any de naixement és de traspàs o falsa si no ho és.
        // En cas de que la variable bool sigui certa, heu de mostrar per consola una frase on ho digui,
        // en cas de ser falsa mostrareu la frase pertinent. Creeu dues variables string per guardar les frases.

        boolean anyDeTraspas = false;
        int anyNaixement = 1980;
        if(calendar.isLeapYear(anyNaixement))
            anyDeTraspas = true;
        else anyDeTraspas = false;

        if(anyDeTraspas)
            System.out.println("L'any " + anyNaixement + " és de trasàs");
        else System.out.println("L'any " + anyNaixement + " no és de trasàs");
    }
}

