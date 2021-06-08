package com.surendavidiants;

import java.util.ArrayList;
import java.util.List;

public class Main {
        public static void main(String[] args) {
        // Nivell 1 - Fase 4

        /*
         * Crea una altra llista amb el teu cognom on cada posició correspongui a una lletra.
         * Fusiona les dues llistes en una sola.
         * A més, afegeix una posició amb un espai buit entre la primera i la segona.
         * És a dir, partim de la llista name i surname i al acabar l’execució només tindrem
         * una que es dirà fullName.
         * */

            List<Character> name = new ArrayList<>();

            name.add('S');
            name.add('U');
            name.add('R');
            name.add('E');
            name.add('N');

            List<Character> surname = new ArrayList<>();
            surname.add('D');
            surname.add('A');
            surname.add('V');
            surname.add('I');
            surname.add('D');
            surname.add('I');
            surname.add('A');
            surname.add('N');
            surname.add('T');
            surname.add('S');

            System.out.println(mergeNameSurname(name, surname));
    }



    private static List<Character> mergeNameSurname(List<Character> name, List<Character> surname){

        List<Character> fullName = new ArrayList<>(name);

        fullName.add(' ');
        fullName.addAll(surname);

        return fullName;
    }
}
