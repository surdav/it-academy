// M3 Nivell 3

/*
 * Escriviu un programa que donat un numero N retorni la seqüència de Fibonacci fins
 * al numero N. La seqüència de Fibonacci és la sèrie de nombres: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
 * El número següent es troba sumant els dos números anteriors.
 *
 * */

package com.surendavidiants;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Introduce un número:");
        int numFib = input.nextInt();

        secuenciaFibonacci(numFib);
    }

    private static void secuenciaFibonacci(int num){
        // Calculamos el número Fibonacci dado un numero entero
        long[] arr = new long[num + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= num; i++)
            arr[i] = arr[i - 1] + arr[i - 2];

        System.out.println("Secuencia de Fibonacci " + num + ":");

        for (int i = 0; i < arr.length - 1; i++){
            System.out.print(arr[i] + " ");
        }
    }
}