package com.floristeria.vista;

import java.util.HashSet;
import java.util.Objects;

import javax.swing.JOptionPane;

import com.floristeria.controlador.FloristeriaControlador;
import com.floristeria.modelo.dominio.Floristeria;

public class UI {

    private final FloristeriaControlador floristeriaControlador;

    public UI() {
        floristeriaControlador = new FloristeriaControlador();
    }

    public void menu() {
        // Crear floristería
        Floristeria floristeria;
        do {
            floristeria = floristeriaCreate();
        } while (floristeria == null);

        // Menú de la aplicación
        boolean exit = false;

        do {
            String option = preguntar("Menú",
                    "Elige una opción:\n1. Añadir producto\n2. Retirar producto\n3. Gestión de productos\n4. Gestión de compras\n5. Salir");

            if (option == null) exit = true;
            else if (option.equals("1")) menuAdd(floristeria);
            else if (option.equals("2")) menuRemove(floristeria);
            else if (option.equals("3")) menuStock(floristeria);
            else if (option.equals("4")) menuTicket(floristeria);
            else if (option.equals("5")) exit = true;

        } while (!exit);
        System.out.println("Final de la aplicación");
    }

    // Menú para añadir un producto
    private void menuAdd(Floristeria floristeria) {

        boolean exit = false;

        do {
            String option = preguntar("Menú", "Elige una opción:\n1. Añadir árbol\n2. Añadir flor\n3. Añadir decoración\n4. Salir");
            if (option == null) exit = true;
            else if (option.equals("1")) askTreeAdd(floristeria);
            else if (option.equals("2")) askFlowerAdd(floristeria);
            else if (option.equals("3")) askDecorationAdd(floristeria);
            else if (option.equals("4")) exit = true;

        } while (!exit);
    }

    // Menú para retirar un producto
    private void menuRemove(Floristeria floristeria) {

        boolean exit = false;

        do {
            String option = preguntar("Menú", "Elige una opción:\n1. Retirar árbol\n2. Retirar flor\n3. Retirar decoración\n4. Salir");

            if (option == null) exit = true;
            else if (option.equals("1")) {
                floristeriaControlador.getProductStock(floristeria, "Arbol");
                askProductRemove(floristeria);
            } else if (option.equals("2")) {
                floristeriaControlador.getProductStock(floristeria, "Flor");
                askProductRemove(floristeria);
            } else if (option.equals("3")) {
                floristeriaControlador.getProductStock(floristeria, "Decoración");
                askProductRemove(floristeria);
            } else if (option.equals("4")) exit = true;

        } while (!exit);
    }

    // Menú para ver el stock y el valor de los productos
    private void menuStock(Floristeria floristeria) {

        boolean exit = false;

        do {
            String option = preguntar("Menú",
                    "Elige una opción:\n1. Ver stock de árboles\n2. Ver stock de flores\n3. Ver stock de decoración\n4. Ver stock de todos los productos\n5. Ver el valor de todos los productos\n6. Salir");

            if (option == null) exit = true;
            else if (option.equals("1")) floristeriaControlador.getProductStock(floristeria, "Arbol");
            else if (option.equals("2")) floristeriaControlador.getProductStock(floristeria, "Flor");
            else if (option.equals("3")) floristeriaControlador.getProductStock(floristeria, "Decoracion");
            else if (option.equals("4")) floristeriaControlador.getAllProductsStock(floristeria);
            else if (option.equals("5")) floristeriaControlador.getStockValue(floristeria);
            else if (option.equals("6")) exit = true;

        } while (!exit);
    }

    // Menú para crear y ver tickets
    private void menuTicket(Floristeria floristeria) {

        boolean exit = false;

        do {
            String option = preguntar("Menú", "Elige una opción:\n1. Crear un nuevo ticket de compra\n2. Ver los tickets de compra antiguos\n3. Ver el valor de las ventas realizadas\n4. Salir");

            if (option == null) exit = true;
            else if (option.equals("1")) {
                floristeriaControlador.getAllProductsStock(floristeria);
                askCreateTicket(floristeria);
            } else if (option.equals("2")) floristeriaControlador.printAllTickets();
            else if (option.equals("3")) floristeriaControlador.getAllTicketsValue();
            else if (option.equals("4")) exit = true;

        } while (!exit);
    }

    // Crear floristería
    private Floristeria floristeriaCreate() {

        Floristeria floristeria = null;

        try {
            String nomFloristeria = preguntar("Nombre floristería", "Introduce el nombre de la floristería");

            if (nomFloristeria == null) System.exit(0);
            else floristeria = floristeriaControlador.createFloristeria(nomFloristeria);

        } catch (Exception e) {
            System.err.println("No se pudo crear la floristería");
            System.err.println(e.getMessage());
        }
        return floristeria;
    }

    // Añadir árbol
    private void askTreeAdd(Floristeria floristeria) {
        try {
            String nombreArbol = preguntar("Nombre Árbol", "Introduce el nombre del árbol");

            if (nombreArbol == null) throw new NullPointerException();

            double arbolAltura = Double.parseDouble(Objects.requireNonNull(preguntar("Altura Árbol", "Introduce la altura del árbol")));

            double arbolPrecio = Double.parseDouble(Objects.requireNonNull(preguntar("Precio Árbol", "Introduce el precio del árbol")));

            floristeriaControlador.addArbol(floristeria, nombreArbol, arbolAltura, arbolPrecio);
        } catch (NullPointerException ignored) {
        } catch (NumberFormatException nfe) {
            System.err.println("No se pudo añadir el árbol");
            System.err.println("Se ha introducido una palabra en lugar de un número");
        } catch (Exception e) {
            System.err.println("No se pudo añadir el árbol");
            System.err.println(e.getMessage());
        }
    }

    // Añadir flor
    private void askFlowerAdd(Floristeria floristeria) {
        try {
            String nombreFlor = preguntar("Nombre Flor", "Introduce el nombre de la flor");
            if (nombreFlor == null) throw new NullPointerException();

            String colorFlor = preguntar("Color Flor", "Introduce el color de la flor");
            if (colorFlor == null) throw new NullPointerException();

            double precioFlor = Double.parseDouble(Objects.requireNonNull(preguntar("Precio Flor", "Introduce el precio de la flor")));

            floristeriaControlador.addFlor(floristeria, nombreFlor, colorFlor, precioFlor);

        } catch (NullPointerException ignored) {
        } catch (NumberFormatException nfe) {
            System.err.println("No se pudo añadir la flor");
            System.err.println("Se ha introducido una palabra en lugar de un número");
        } catch (Exception e) {
            System.err.println("No se pudo añadir la flor");
            System.err.println(e.getMessage());
        }
    }

    // Añadir decoración
    private void askDecorationAdd(Floristeria floristeria) {
        try {
            String nombreDecoracion = preguntar("Nombre Decoración", "Introduce el nombre de la decoración");
            if (nombreDecoracion == null) throw new NullPointerException();

            String tipoDecoracion = preguntar("Tipo Decoración", "Introduce el tipo de decoración (madera o plastico)");
            if (tipoDecoracion == null) throw new NullPointerException();

            double precioDecoracion = Double.parseDouble(Objects.requireNonNull(preguntar("Precio Decoración", "Introduce el precio de la decoración")));

            floristeriaControlador.addDecoracion(floristeria, nombreDecoracion, tipoDecoracion, precioDecoracion);
        } catch (NullPointerException ignored) {
        } catch (NumberFormatException nfe) {
            System.err.println("No se pudo añadir la decoración");
            System.err.println("Se ha introducido una palabra en lugar de un número");
        } catch (Exception e) {
            System.err.println("No se pudo añadir la decoración");
            System.err.println(e.getMessage());
        }
    }

    // Retirar producto
    private void askProductRemove(Floristeria floristeria) {
        try {
            String response = preguntar("ID Producto", "Introduce el ID del producto a eliminar");
            if (response == null) throw new NullPointerException();

            int productId = Integer.parseInt(response);

            floristeriaControlador.removerProducto(floristeria, productId);

            System.out.println("Producto eliminado correctamente.");

        } catch (NullPointerException ignored) {
        } catch (NumberFormatException nfe) {
            System.err.println("No se pudo retirar el producto");
            System.err.println("Se ha introducido una palabra en lugar de un número");
        } catch (Exception e) {
            System.err.println("No se pudo retirar el producto");
            System.err.println(e.getMessage());
        }
    }

    // Crear ticket
    private void askCreateTicket(Floristeria floristeria) {
        HashSet<Integer> idsTicket = new HashSet<>();
        boolean exit = false;
        do {
            try {
                String response = preguntar("ID Producto", "Introduce el ID del producto a añadir al ticket de compra");
                if (response == null) throw new NullPointerException();
                int productId = Integer.parseInt(response);
                if (!floristeriaControlador.comprobarId(floristeria, productId)) throw new IllegalArgumentException();
                idsTicket.add(productId);
            } catch (NullPointerException npe) {
                return;
            } catch (NumberFormatException nfe) {
                System.err.println("Se ha introducido una palabra en lugar de un número");
            } catch (Exception e) {
                System.err.println("No hay ningún producto con este ID");
            }
            int confirmacion = JOptionPane.showConfirmDialog(null, "Desea añadir otro producto en el ticket de compra?");
            switch (confirmacion) {
                case 0:
                    break;
                case 1:
                    exit = true;
                    break;
                case 2:
                    return;
            }
        } while (!exit);

        try {
            floristeriaControlador.createTicket(floristeria, idsTicket);
        } catch (Exception e) {
            System.err.println("No se pudo crear el ticket");
            System.err.println(e.getMessage());
        }
    }

    // Preguntar al usuario
    private String preguntar(String title, String question) {
        String response;
        do {
            response = JOptionPane.showInputDialog(null, question, title, JOptionPane.QUESTION_MESSAGE);
            if (response == null) return null;
            if (response.isBlank()) System.err.println("No se puede dejar este campo en blanco.");
        } while (response.isBlank());
        return response;
    }

}
