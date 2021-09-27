package com.floristeria.modelo.dominio;

public class Arbol extends Producto {

	private final String name;
	private final double height;

	public Arbol(String name, double height, double price) throws Exception {
		super(price);
		if (name.isBlank()) throw new Exception("Debe introducir un nombre del árbol.");
		this.name = name;
		this.height = height;
	}

	@Override
	public String toString() {
		return "	ID: " + this.getId() + "	NOMBRE: " + name + "	ALTURA: " + height + "	PRECIO: " + this.getPrice();

	}

}
