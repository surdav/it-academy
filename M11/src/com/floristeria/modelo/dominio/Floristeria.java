package com.floristeria.modelo.dominio;

import java.util.List;
import java.util.stream.Collectors;

import com.floristeria.controlador.NoContentException;
import com.floristeria.controlador.WrongMaterialException;
import com.floristeria.modelo.dominio.Decoracion.Material;
import com.floristeria.modelo.servicio.FloristeriaRepo;
import com.floristeria.vista.UI;

public class Floristeria {

	private String floristeriaName;
	private final FloristeriaRepo floristeriaRepo = new FloristeriaRepo();
	private UI ui = new UI();
	
	public Floristeria(String name) throws NoContentException {
		if (name.isBlank()) throw new NoContentException("Debe introducir un nombre para la tienda.");
		
		floristeriaName = name;
	}

	public String getFloristeriaName() {
		return floristeriaName;
	}

	public void addTree(String name, double height, double price) throws NoContentException {

		Arbol arbol = new Arbol(name, height, price);
		floristeriaRepo.addProduct(arbol);
		ui.mostrarMsg("Árbol añadido correctamente.");
	}

	public void addFlower(String name, String color, double price) throws NoContentException {

		Flor flor = new Flor(name, color, price);
		floristeriaRepo.addProduct(flor);
		ui.mostrarMsg("Flor añadida correctamente.");

	}

	public void addDecoration(String name, Material type, double price) throws NoContentException, WrongMaterialException {

		Decoracion decoracion = new Decoracion(name, type, price);
		floristeriaRepo.addProduct(decoracion);
		ui.mostrarMsg("Decoración añadida correctamente.");
	}
	
	public void removeProduct(int id) throws NoContentException {
		floristeriaRepo.removeProduct(id);
	}
	
	public List<Producto> getAllProducts(){
		return floristeriaRepo.getAllProducts();
	}
	
	// imprime todo el stock
	public void printStock() {
	
		// Recorre el listado y captura una lista de los tipos de Clases que hay presentes.
		List<String> productTypes = floristeriaRepo.getAllProducts()
				.stream().map(p->p.getClass().getSimpleName())
				.distinct()
				.collect(Collectors.toList());

		// Imprime una lista para cada tipo encontrado
		ui.mostrarMsg("----- Stock actualizado -----");
		for (String s : productTypes) {
			printStock(s);
		}
	}
	
	// Imprime una lista de un producto concreto
	public void printStock(String product) {
		
		// Define el título del listado en función del producto
		String tipo = switch (product) {
			case "Arbol" -> "ÁRBOLES";
			case "Flor" -> "FLORES";
			case "Decoracion" -> "DECORACIONES";
			default -> "";
		};

		// Imprime el listado
		ui.mostrarMsg("TOTAL " + tipo + ": ");
		for (Producto p : floristeriaRepo.getAllProducts()) {
			if (p.getClass().getSimpleName().equals(product)) {
				ui.mostrarMsg(p.toString());
			}
		}
	}

	public void totalStockValue() {
		
		ui.mostrarMsg("VALOR TOTAL DEL STOCK: "+
		
		floristeriaRepo.getAllProducts().stream()
			.mapToDouble(Producto::getPrice)
			.sum());
	}
}
