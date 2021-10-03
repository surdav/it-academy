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
        // Crear floristería
        Floristeria floristeria;
        do {
            floristeria = floristeriaCreate();
        } while (floristeria == null);

        // Menú de la aplicación
        boolean exit = false;

        do {
            String option = preguntar("Menú: '" + floristeria.getFloristeriaName().toUpperCase() + "'",
                    "Elige una opción:\n1. Añadir producto\n2. Retirar producto\n3. Gestión de productos\n4. Gestión de compras\n5. Salir");

            if (option == null) exit = true;
            else if (option.equals("1")) menuAdd(floristeria);
            else if (option.equals("2")) menuRemove(floristeria);
            else if (option.equals("3")) menuStock(floristeria);
            else if (option.equals("4")) menuTicket(floristeria);
            else if (option.equals("5")) exit = true;

        } while (!exit);
        mostrarMsg("Final de la aplicación");
    }

    // Menú para añadir un producto
    private void menuAdd(Floristeria floristeria) {

        boolean exit = false;

        do {
            String option = preguntar("Menú: '" + floristeria.getFloristeriaName().toUpperCase() + "'",
            		"Elige una opción:\n1. Añadir árbol\n2. Añadir flor\n3. Añadir decoración\n4. Salir");
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
            String option = preguntar("Menú: '" + floristeria.getFloristeriaName().toUpperCase() + "'", 
            		"Elige una opción:\n1. Retirar árbol\n2. Retirar flor\n3. Retirar decoración\n4. Salir");

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


	// Menú para ver el stock y el valor de los productos
    private void menuStock(Floristeria floristeria) {

        boolean exit = false;

        do {
            String option = preguntar("Menú: '" + floristeria.getFloristeriaName().toUpperCase() + "'",
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
            String option = preguntar("Menú: '" + floristeria.getFloristeriaName().toUpperCase() + "'", 
            		"Elige una opción:\n1. Crear un nuevo ticket de compra\n2. Ver los tickets de compra antiguos\n3. Ver el valor de las ventas realizadas\n4. Salir");

            if (option == null) exit = true;
            else if (option.equals("1")) {
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

        } catch (NullPointerException ignored) {
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

            if (nombreArbol == null) throw new NoContentException();

            double arbolAltura = Double.parseDouble(Objects.requireNonNull(preguntar("Altura Árbol", "Introduce la altura del árbol")));

            double arbolPrecio = Double.parseDouble(Objects.requireNonNull(preguntar("Precio Árbol", "Introduce el precio del árbol")));

            floristeriaControlador.addArbol(floristeria, nombreArbol, arbolAltura, arbolPrecio);
        } catch (NullPointerException ignored) {
        } catch (NumberFormatException nfe) {
            System.err.println("No se pudo añadir el árbol");
            System.err.println("Se ha introducido una palabra en lugar de un número");
        } catch (NoContentException e) {
            System.err.println("No se pudo añadir el árbol");
            System.err.println(e.getMessage());
        }
    }

    // Añadir flor
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
            System.err.println("No se pudo añadir la flor");
            System.err.println("Se ha introducido una palabra en lugar de un número");
        } catch (NoContentException e) {
            System.err.println("No se pudo añadir la flor");
            System.err.println(e.getMessage());
        }
    }

    // Añadir decoración
    private void askDecorationAdd(Floristeria floristeria) {
        try {
        	Material material = null;
            String nombreDecoracion = preguntar("Nombre Decoración", "Introduce el nombre de la decoración");
            if (nombreDecoracion == null) throw new NoContentException();

            String tipoDecoracion = preguntar("Tipo Decoración", "Introduce el tipo de decoración (madera o plastico)");
            
            if (tipoDecoracion.equals("madera")) {
            	material = Material.MADERA;
            } else if (tipoDecoracion.equals("plastico")) {
            	material = Material.PLASTICO;      
            }
            
            if (material == null) throw new WrongMaterialException("La decoración sólo puede ser de MADERA o PLASTICO");
            
            double precioDecoracion = Double.parseDouble(Objects.requireNonNull(preguntar("Precio Decoración", "Introduce el precio de la decoración")));

            floristeriaControlador.addDecoracion(floristeria, nombreDecoracion, material, precioDecoracion);
        } catch (NullPointerException ignored) {
        } catch (NumberFormatException nfe) {
            System.err.println("No se pudo añadir la decoración");
            System.err.println("Se ha introducido una palabra en lugar de un número");
        } catch (NoContentException e) {
            System.err.println("No se pudo añadir la decoración");
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
            	mostrarMsg("Dentro de la sección '" + tipoProducto.toUpperCase() + "' no hay ningún producto con esta ID");
            }
            
        } catch (NullPointerException ignored) {
        } catch (NumberFormatException nfe) {
            System.err.println("No se pudo retirar el producto");
            System.err.println("Se ha introducido una palabra en lugar de un número");
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
                String response = preguntar("ID Producto", "Introduce el ID del producto a añadir al ticket de compra");
                if (response == null) throw new NullPointerException();
                int productId = Integer.parseInt(response);
                if (!floristeriaControlador.comprobarId(floristeria, productId)) throw new NoContentException();
                // Añado el id del producto a la lista de IDs
//                idsTicket.add(productId);
                // Con el ID localizo la posición en el array de productos
                int idProdTicket = floristeriaControlador.comprobarIndexLista(floristeria, productId);
                // Añado el producto elegido a la lista de productos que irán al ticket, y lo elimino del stock general para no poder comprarlo de nuevo
                productosTicket.add(floristeria.getAllProducts().get(idProdTicket));
            	floristeriaControlador.removerProducto(floristeria, productId);
            } catch (NullPointerException npe) {
                return;
            } catch (NumberFormatException nfe) {
                System.err.println("Se ha introducido una palabra en lugar de un número");
            } catch (NoContentException e) {
                System.err.println("No hay ningún producto con este ID");
            }
            int confirmacion = JOptionPane.showConfirmDialog(null, "Desea añadir otro producto en el ticket de compra?");
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
    
    // Método para mostrar mensajes del modelo o del constructor
    public void mostrarMsg(String msg) {
    	System.out.println(msg);
    }
    
}
