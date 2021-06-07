package com.surendavidiants;

public class Main {
    public static void main(String[] args) {
        // M1 Nivell 3
        /*
         * Declara un array de numeros int e inicialitzala amb valors del 1 al 10
         * Rota l’array sense utilitzar un array auxiliar ni llibreries.
         * Pots utilizar una variable auxiliar
         * */
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("El array original:");
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");


            int ultimo = array[array.length - 1];

            for (int j = array.length - 2; j >= 0; j--)
                array[j + 1] = array[j];

            array[0] = ultimo;

        System.out.println("\n\nEl array después de la rotación:");
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");

    }

}
