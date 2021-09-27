package com.floristeria.modelo.dominio;

import java.util.List;
import java.util.stream.Collectors;

import com.floristeria.modelo.servicio.FloristeriaRepo;

public class Floristeria {

	private final FloristeriaRepo floristeriaRepo = new FloristeriaRepo();
	
	public Floristeria(String name) throws Exception {
		if (name.isBlank()) throw new Exception("Debe introducir un nombre para la tienda.");
	}

	public void addTree(String name, double height, double price) throws Exception {

		Arbol arbol = new Arbol(name, height, price);
		floristeriaRepo.addProduct(arbol);
		System.out.println("Árbol añadido correctamente.");
	}

	public void addFlower(String name, String color, double price) throws Exception {

		Flor flor = new Flor(name, color, price);
		floristeriaRepo.addProduct(flor);
		System.out.println("Flor añadida correctamente.");

	}

	public void addDecoration(String name, String type, double price) throws Exception {

		Decoracion decoracion = new Decoracion(name, type, price);
		floristeriaRepo.addProduct(decoracion);
		System.out.println("Decoración añadida correctamente.");
	}
	
	public void removeProduct(int id) throws Exception {
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
		System.out.println("TOTAL " + tipo + ": ");
		for (Producto p : floristeriaRepo.getAllProducts()) {
			if (p.getClass().getSimpleName().equals(product)) {
				System.out.println(p);
			}
		}
	}

	public void totalStockValue() {
		
		System.out.println("VALOR TOTAL DEL STOCK: "+
		
		floristeriaRepo.getAllProducts().stream()
			.mapToDouble(Producto::getPrice)
			.sum());
	}
}
