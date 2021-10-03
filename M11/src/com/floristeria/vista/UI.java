package com.floristeria.vista;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;

import com.floristeria.controlador.FloristeriaControlador;
import com.floristeria.controlador.NoContentException;
import com.floristeria.controlador.WrongMaterialException;
import com.floristeria.modelo.dominio.Arbol;
import com.floristeria.modelo.dominio.Decoracion;
import com.floristeria.modelo.dominio.Decoracion.Material;
import com.floristeria.modelo.dominio.Flor;
import com.floristeria.modelo.dominio.Floristeria;
import com.floristeria.modelo.dominio.Producto;

public class UI {

    private final FloristeriaControlador floristeriaControlador;

    public UI() {
        floristeriaControlador = new FloristeriaControlador();
    }

    public void menu() {
        // Crear florister�a
        Floristeria floristeria;
        do {
            floristeria = floristeriaCreate();
        } while (floristeria == null);

        // Men� de la aplicaci�n
        boolean exit = false;

        do {
            String option = preguntar("Men�: '" + floristeria.getFloristeriaName().toUpperCase() + "'",
                    "Elige una opci�n:\n1. A�adir producto\n2. Retirar producto\n3. Gesti�n de productos\n4. Gesti�n de compras\n5. Salir");

            if (option == null) exit = true;
            else if (option.equals("1")) menuAdd(floristeria);
            else if (option.equals("2")) menuRemove(floristeria);
            else if (option.equals("3")) menuStock(floristeria);
            else if (option.equals("4")) menuTicket(floristeria);
            else if (option.equals("5")) exit = true;

        } while (!exit);
        mostrarMsg("Final de la aplicaci�n");
    }

    // Men� para a�adir un producto
    private void menuAdd(Floristeria floristeria) {

        boolean exit = false;

        do {
            String option = preguntar("Men�: '" + floristeria.getFloristeriaName().toUpperCase() + "'",
            		"Elige una opci�n:\n1. A�adir �rbol\n2. A�adir flor\n3. A�adir decoraci�n\n4. Salir");
            if (option == null) exit = true;
            else if (option.equals("1")) askTreeAdd(floristeria);
            else if (option.equals("2")) askFlowerAdd(floristeria);
            else if (option.equals("3")) askDecorationAdd(floristeria);
            else if (option.equals("4")) exit = true;

        } while (!exit);
    }

    // Men� para retirar un producto
    private void menuRemove(Floristeria floristeria) {

        boolean exit = false;

        do {
            String option = preguntar("Men�: '" + floristeria.getFloristeriaName().toUpperCase() + "'", 
            		"Elige una opci�n:\n1. Retirar �rbol\n2. Retirar flor\n3. Retirar decoraci�n\n4. Salir");

            if (option == null) exit = true;
            else if (option.equals("1")) {
                floristeriaControlador.getProductStock(floristeria, "Arbol");
                askProductRemove(floristeria, "Arbol");
            } else if (option.equals("2")) {
                floristeriaControlador.getProductStock(floristeria, "Flor");
                askProductRemove(floristeria, "Flor");
            } else if (option.equals("3")) {
                floristeriaControlador.getProductStock(floristeria, "Decoracion");
                askProductRemove(floristeria, "Decoracion");
            } else if (option.equals("4")) exit = true;

        } while (!exit);
    }


	// Men� para ver el stock y el valor de los productos
    private void menuStock(Floristeria floristeria) {

        boolean exit = false;

        do {
            String option = preguntar("Men�: '" + floristeria.getFloristeriaName().toUpperCase() + "'",
                    "Elige una opci�n:\n1. Ver stock de �rboles\n2. Ver stock de flores\n3. Ver stock de decoraci�n\n4. Ver stock de todos los productos\n5. Ver el valor de todos los productos\n6. Salir");

            if (option == null) exit = true;
            else if (option.equals("1")) floristeriaControlador.getProductStock(floristeria, "Arbol");
            else if (option.equals("2")) floristeriaControlador.getProductStock(floristeria, "Flor");
            else if (option.equals("3")) floristeriaControlador.getProductStock(floristeria, "Decoracion");
            else if (option.equals("4")) floristeriaControlador.getAllProductsStock(floristeria);
            else if (option.equals("5")) floristeriaControlador.getStockValue(floristeria);
            else if (option.equals("6")) exit = true;

        } while (!exit);
    }

    // Men� para crear y ver tickets
    private void menuTicket(Floristeria floristeria) {

        boolean exit = false;

        do {
            String option = preguntar("Men�: '" + floristeria.getFloristeriaName().toUpperCase() + "'", 
            		"Elige una opci�n:\n1. Crear un nuevo ticket de compra\n2. Ver los tickets de compra antiguos\n3. Ver el valor de las ventas realizadas\n4. Salir");

            if (option == null) exit = true;
            else if (option.equals("1")) {
                askCreateTicket(floristeria);
            } else if (option.equals("2")) floristeriaControlador.printAllTickets();
            else if (option.equals("3")) floristeriaControlador.getAllTicketsValue();
            else if (option.equals("4")) exit = true;

        } while (!exit);
    }

    // Crear florister�a
    private Floristeria floristeriaCreate() {

        Floristeria floristeria = null;

        try {
            String nomFloristeria = preguntar("Nombre florister�a", "Introduce el nombre de la florister�a");

            if (nomFloristeria == null) System.exit(0);
            else floristeria = floristeriaControlador.createFloristeria(nomFloristeria);

        } catch (NullPointerException ignored) {
        } catch (Exception e) {
            System.err.println("No se pudo crear la florister�a");
            System.err.println(e.getMessage());
        }
        return floristeria;
    }

    // A�adir �rbol
    private void askTreeAdd(Floristeria floristeria) {
        try {
            String nombreArbol = preguntar("Nombre �rbol", "Introduce el nombre del �rbol");

            if (nombreArbol == null) throw new NoContentException();

            double arbolAltura = Double.parseDouble(Objects.requireNonNull(preguntar("Altura �rbol", "Introduce la altura del �rbol")));

            double arbolPrecio = Double.parseDouble(Objects.requireNonNull(preguntar("Precio �rbol", "Introduce el precio del �rbol")));

            floristeriaControlador.addArbol(floristeria, nombreArbol, arbolAltura, arbolPrecio);
        } catch (NullPointerException ignored) {
        } catch (NumberFormatException nfe) {
            System.err.println("No se pudo a�adir el �rbol");
            System.err.println("Se ha introducido una palabra en lugar de un n�mero");
        } catch (NoContentException e) {
            System.err.println("No se pudo a�adir el �rbol");
            System.err.println(e.getMessage());
        }
    }

    // A�adir flor
    private void askFlowerAdd(Floristeria floristeria) {
        try {
            String nombreFlor = preguntar("Nombre Flor", "Introduce el nombre de la flor");
            if (nombreFlor == null) throw new NoContentException();

            String colorFlor = preguntar("Color Flor", "Introduce el color de la flor");
            if (colorFlor == null) throw new NoContentException();

            double precioFlor = Double.parseDouble(Objects.requireNonNull(preguntar("Precio Flor", "Introduce el precio de la flor")));

            floristeriaControlador.addFlor(floristeria, nombreFlor, colorFlor, precioFlor);

        } catch (NullPointerException ignored) {
        } catch (NumberFormatException nfe) {
            System.err.println("No se pudo a�adir la flor");
            System.err.println("Se ha introducido una palabra en lugar de un n�mero");
        } catch (NoContentException e) {
            System.err.println("No se pudo a�adir la flor");
            System.err.println(e.getMessage());
        }
    }

    // A�adir decoraci�n
    private void askDecorationAdd(Floristeria floristeria) {
        try {
        	Material material = null;
            String nombreDecoracion = preguntar("Nombre Decoraci�n", "Introduce el nombre de la decoraci�n");
            if (nombreDecoracion == null) throw new NoContentException();

            String tipoDecoracion = preguntar("Tipo Decoraci�n", "Introduce el tipo de decoraci�n (madera o plastico)");
            
            if (tipoDecoracion.equals("madera")) {
            	material = Material.MADERA;
            } else if (tipoDecoracion.equals("plastico")) {
            	material = Material.PLASTICO;      
            }
            
            if (material == null) throw new WrongMaterialException("La decoraci�n s�lo puede ser de MADERA o PLASTICO");
            
            double precioDecoracion = Double.parseDouble(Objects.requireNonNull(preguntar("Precio Decoraci�n", "Introduce el precio de la decoraci�n")));

            floristeriaControlador.addDecoracion(floristeria, nombreDecoracion, material, precioDecoracion);
        } catch (NullPointerException ignored) {
        } catch (NumberFormatException nfe) {
            System.err.println("No se pudo a�adir la decoraci�n");
            System.err.println("Se ha introducido una palabra en lugar de un n�mero");
        } catch (NoContentException e) {
            System.err.println("No se pudo a�adir la decoraci�n");
            System.err.println(e.getMessage());
        } catch (WrongMaterialException wrMat) {
        	System.err.println(wrMat.getMessage());
        }
    }

    // Retirar producto
    private void askProductRemove(Floristeria floristeria, String tipoProducto) {
    	try {
            String response = preguntar("ID Producto", "Introduce el ID del producto a eliminar");
            if (response == null) throw new NullPointerException();

            int productId = Integer.parseInt(response);
            
            List<Producto> listaProductos = floristeria.getAllProducts();
            Producto prod = null;
            for (int i = 0; i < listaProductos.size(); i++) {
            	if (listaProductos.get(i).getId() == productId) {
            		prod = listaProductos.get(i);
            	}
            }
            if (prod instanceof Arbol && tipoProducto == "Arbol") {
            	floristeriaControlador.removerProducto(floristeria, productId);
                mostrarMsg("Producto eliminado correctamente.");
            } else if (prod instanceof Flor && tipoProducto == "Flor") {
            	floristeriaControlador.removerProducto(floristeria, productId);
                mostrarMsg("Producto eliminado correctamente.");            
            } else if (prod instanceof Decoracion && tipoProducto == "Decoracion") {
            	floristeriaControlador.removerProducto(floristeria, productId);
                mostrarMsg("Producto eliminado correctamente.");            
            } else {
            	mostrarMsg("Dentro de la secci�n '" + tipoProducto.toUpperCase() + "' no hay ning�n producto con esta ID");
            }
            
        } catch (NullPointerException ignored) {
        } catch (NumberFormatException nfe) {
            System.err.println("No se pudo retirar el producto");
            System.err.println("Se ha introducido una palabra en lugar de un n�mero");
        } catch (NoContentException e) {
            System.err.println("No se pudo retirar el producto");
            System.err.println(e.getMessage());
        }		
	}
    
    // Crear ticket
    private void askCreateTicket(Floristeria floristeria) {
//        HashSet<Integer> idsTicket = new HashSet<>();
        List<Producto> productosTicket = new ArrayList<>(); 
        boolean exit = false;
    	mostrarMsg("----- Stock actualizado -----");
        floristeriaControlador.getAllProductsStock(floristeria);
        do {
            try {
                String response = preguntar("ID Producto", "Introduce el ID del producto a a�adir al ticket de compra");
                if (response == null) throw new NullPointerException();
                int productId = Integer.parseInt(response);
                if (!floristeriaControlador.comprobarId(floristeria, productId)) throw new NoContentException();
                // A�ado el id del producto a la lista de IDs
//                idsTicket.add(productId);
                // Con el ID localizo la posici�n en el array de productos
                int idProdTicket = floristeriaControlador.comprobarIndexLista(floristeria, productId);
                // A�ado el producto elegido a la lista de productos que ir�n al ticket, y lo elimino del stock general para no poder comprarlo de nuevo
                productosTicket.add(floristeria.getAllProducts().get(idProdTicket));
            	floristeriaControlador.removerProducto(floristeria, productId);
            } catch (NullPointerException npe) {
                return;
            } catch (NumberFormatException nfe) {
                System.err.println("Se ha introducido una palabra en lugar de un n�mero");
            } catch (NoContentException e) {
                System.err.println("No hay ning�n producto con este ID");
            }
            int confirmacion = JOptionPane.showConfirmDialog(null, "Desea a�adir otro producto en el ticket de compra?");
            switch (confirmacion) {
                case 0:		// Yes
                	mostrarMsg("----- Stock actualizado -----");
                	floristeriaControlador.getAllProductsStock(floristeria);
                    break;
                case 1:		// No
                    exit = true;
                    break;
                case 2:		// Cancel
                    return;
            }
        } while (!exit);

        try {
        	mostrarMsg("----- Ticket -----");
            floristeriaControlador.createTicket(floristeria, productosTicket);
        } catch (NoContentException e) {
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
    
    // M�todo para mostrar mensajes del modelo o del constructor
    public void mostrarMsg(String msg) {
    	System.out.println(msg);
    }
    
}
