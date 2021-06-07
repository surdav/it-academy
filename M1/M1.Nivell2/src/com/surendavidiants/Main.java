package com.surendavidiants;

public class Main {
    public static void main(String[] args) {
        // M1 Nivell 2
        /*
        * Declara una variable double. Assigna-li un valor amb 4 decimals
        * Declara variables de tipus: int, float i string
        * Fes un "cast" de la variable double a cada una de les variables que
        * has creat anteriorment per inicialitzar-les i pinta-les per pantalla.
        * */
        double d = 3.1416;
        int i;
        float f;
        String s;

        i = (int) d;
        f = (float) d;
        s = Double.toString(d);

        System.out.println(d + " double");
        System.out.println(i + " int");
        System.out.println(f + " float");
        System.out.println(s + " string");
    }
}
