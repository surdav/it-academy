// M2 Nivell 3

/*
 * En aquest exercici es proposa un exercici complex de comprovacions i bucles per
 * crear un cronòmetre  digital que vagi mostrant el temps transcorregut en format
 * rellotge hh:mm:ss amb un segon d'espera.
 *
 * Només necessites 3 variables int (hour, minutes, seconds)
 *
 * El cronòmetre ha de tenir 6 dígits en tot moment i ha d'iniciar a 00:00:00
 *
 * Per que el rellotge trigui un segon has d’implementar: Thread.sleep(1000);
 * */


package com.surendavidiants;

import java.util.Formatter;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int hour = 0, minutes = 0, seconds = 0;

        while (true){
            Thread.sleep(1000);
            seconds++;
            if (seconds == 60){
                minutes++;
                seconds = 0;
            }

            if (minutes == 60){
                hour++;
                minutes = 0;
            }
            Formatter fmt = new Formatter();
            fmt.format("%1$02d:%2$02d:%3$02d", hour, minutes, seconds);
            System.out.println(fmt);
        }
    }
}

