package com.surendavidiants;

public class Main {

    public static void main(String[] args) {
        // Nivell 1 - Fase 1

        // Crea tres variables string e inicialitzales amb les dades pertinents (nom, cognom1, cognom2).
        String nom = "Lionel";
        String cognom1 = "Messi";
        String cognom2 = "Cuccittini";

        // Crea tres variables int e inicialitzales amb les dades pertinents (dia, mes, any).
        int dia = 24;
        int mes = 6;
        int any = 1987;

        // Mostra per pantalla les variables string concatenant-les en aquest ordre (cognom1 + cognom2, + nom).
        System.out.println(cognom1 + " " + cognom2 + ", " + nom);

        // Mostra per pantalla les variables int concatenant-les amb “/” entre cada una d’elles.
        System.out.println(dia + "/" + mes + "/" + any);
    }
}

