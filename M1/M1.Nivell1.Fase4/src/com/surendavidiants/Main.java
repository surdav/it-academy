package com.surendavidiants;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        // Nivell 1 - Fase 4

        // Crea tres variables string e inicialitzales amb les dades pertinents (nom, cognom1, cognom2).
        String nom = "Lionel";
        String cognom1 = "Messi";
        String cognom2 = "Cuccittini";
        String nombreCompleto = nom + " " + cognom1 + " " + cognom2;

        // Crea tres variables int e inicialitzales amb les dades pertinents (dia, mes, any).
        int dia = 24;
        int mes = 6;

        // !!! DEFINIR AQUÍ TU AÑO DE NACIMIENTO
        int anyNaixement = 1987;
        String dataNaixement = dia + "/" + mes + "/" + anyNaixement;


        GregorianCalendar calendar = new GregorianCalendar();
        boolean anyDeTraspas = false;

        if(calendar.isLeapYear(anyNaixement))
            anyDeTraspas = true;
        else anyDeTraspas = false;

        System.out.println("El meu nom és " + nombreCompleto);
        System.out.println("Vaig néixer el " + dataNaixement);

        if(anyDeTraspas)
            System.out.println("L'any " + anyNaixement + " és de trasàs");
        else System.out.println("L'any " + anyNaixement + " no és de trasàs");

    }
}

