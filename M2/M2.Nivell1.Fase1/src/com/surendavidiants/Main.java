package com.surendavidiants;

public class Main {

    public static void main(String[] args) {
        // Nivell 1 - Fase 1

        // Crea una taula (char[]) amb el teu nom on cada posició correspongui a
        // una lletra.
        char[] nom = {'s', 'u', 'r', 'e', 'n'};

        // Fes un bucle que recorri aquesta taula i mostri per consola cadascuna de
        // les lletres.
        for (char el : nom) {
            System.out.println(el);
        }
    }
}