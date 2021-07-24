package com.vehicles.project;

import com.vehicles.project.excepciones.RevisioTipus;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RevisioTipus {

        Scanner scanner = new Scanner(System.in);

        // variables temporales para crear el coche
        String matricula;
        String marca;
        String color;

        // variables temporales para crear las ruedas delanteras
        String marcaRuedasDelanteras;
        double diametroRuedasDelanteras;

        // variables temporales para crear las ruedas traseras
        String marcaRuedasTraseras;
        double diametroRuedasTraseras;

        int opcionCocheMoto;

        System.out.println("Quieres crear un coche o una moto? Pulsa 1 para coche y 2 para moto");

        try {
            if (scanner.hasNextInt()) opcionCocheMoto = scanner.nextInt();
            else throw new RevisioTipus("La entrada tiene que ser numérica");
        } catch (RevisioTipus e) {
            System.err.println("La entrada tiene que ser numérica");
            return;
        }
        scanner.nextLine();

        if (opcionCocheMoto == 1) {

            while (true) {
                System.out.println("Cúal es la matricula de tu coche?");
                matricula = scanner.nextLine();
                if (validarMatricula(matricula))
                    System.out.println("El formato de la matricula tiene que ser uno de los siguientes: 1234ABC o 1234AB");
                else break;
            }

            System.out.println("Cúal es la marca del coche?");
            marca = scanner.nextLine();

            System.out.println("Cúal es el color del coche?");
            color = scanner.nextLine();


            System.out.println("Cúal es la marca de las ruedas delanteras?");
            marcaRuedasDelanteras = scanner.nextLine();

            while (true) {
                System.out.println("Cúal es el diámetro de la ruedas delanteras?");

                diametroRuedasDelanteras = revisionTipoDouble();

                if (validarDiametroRueda(diametroRuedasDelanteras))
                    System.out.println("El diámetro de la rueda tiene que ser superio a 0.4 y inferior a 4");
                else break;

            }


            System.out.println("Cúal es la marca de las ruedas traseras?");
            marcaRuedasTraseras = scanner.nextLine();

            while (true) {
                System.out.println("Cúal es el diámetro de la ruedas traseras?");

                diametroRuedasTraseras = revisionTipoDouble();

                if (validarDiametroRueda(diametroRuedasTraseras))
                    System.out.println("El diámetro de la rueda tiene que ser superio a 0.4 y inferior a 4");
                else break;
            }


            // creación de objetos

            Car miCoche = new Car(matricula, marca, color);

            Wheel ruedaDelantera = new Wheel(marcaRuedasDelanteras, diametroRuedasDelanteras);
            Wheel ruedaTrasera = new Wheel(marcaRuedasTraseras, diametroRuedasTraseras);

            List<Wheel> ruedasDelanteras = new ArrayList<>();
            ruedasDelanteras.add(ruedaDelantera);
            ruedasDelanteras.add(ruedaDelantera);

            List<Wheel> ruedasTraseras = new ArrayList<>(); //
            ruedasTraseras.add(ruedaTrasera);
            ruedasTraseras.add(ruedaTrasera);

            try {
                miCoche.addWheels(ruedasDelanteras, ruedasTraseras);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(miCoche);

        } // FIN DE CREACIÓN DEL COCHE
        else if (opcionCocheMoto == 2) {

            while (true) {
                System.out.println("Cúal es la matricula de tu moto?");
                matricula = scanner.nextLine();
                if (validarMatricula(matricula))
                    System.out.println("El formato de la matricula tiene que ser uno de los siguientes: 1234ABC o 1234AB");
                else break;
            }

            System.out.println("Cúal es la marca de la moto?");
            marca = scanner.nextLine();

            System.out.println("Cúal es el color de la moto?");
            color = scanner.nextLine();


            System.out.println("Cúal es la marca de la rueda delantera?");
            marcaRuedasDelanteras = scanner.nextLine();

            while (true) {
                System.out.println("Cúal es el diámetro de la rueda delantera?");
                diametroRuedasDelanteras = revisionTipoDouble();
                if (validarDiametroRueda(diametroRuedasDelanteras))
                    System.out.println("El diámetro de la rueda tiene que ser superio a 0.4 y inferior a 4");
                else break;

            }


            System.out.println("Cúal es la marca de la rueda trasera?");
            marcaRuedasTraseras = scanner.nextLine();

            while (true) {
                System.out.println("Cúal es el diámetro de la rueda trasera?");
                diametroRuedasTraseras = revisionTipoDouble();
                if (validarDiametroRueda(diametroRuedasTraseras))
                    System.out.println("El diámetro de la rueda tiene que ser superio a 0.4 y inferior a 4");
                else break;
            }


            // creación de objetos

            Bike miMoto = new Bike(matricula, marca, color);

            Wheel ruedaDelantera = new Wheel(marcaRuedasDelanteras, diametroRuedasDelanteras);
            Wheel ruedaTrasera = new Wheel(marcaRuedasTraseras, diametroRuedasTraseras);

            miMoto.addWheels(ruedaDelantera, ruedaTrasera);

            System.out.println(miMoto);

        } // FIN DE CREACIÓN DE LA MOTO
        else System.out.println("Tal opción no existe! Adiós!");

    }

    public static boolean validarMatricula(String matricula) {
        return !matricula.matches("^[0-9]{4}[a-zA-Z]{2,3}$");
    }

    public static boolean validarDiametroRueda(double diametro) {
        return !(diametro > 0.4) || !(diametro < 4);
    }

    public static double revisionTipoDouble() {
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            try
            {
                return sc.nextDouble();
            }
            catch (InputMismatchException e)
            {
                sc.next();
                System.out.println("El diámetro tiene que ser una entrada numérica!");
            }
        }
    }

}