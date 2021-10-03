package com.floristeria.modelo.dominio;

import com.floristeria.controlador.NoContentException;

public class Flor extends Producto {

	private final String name;
	private final String color;

	public Flor(String name, String color, double price) throws NoContentException {
		super(price);
		if (name.isBlank()) throw new NoContentException("Debe introducir un nombre de la flor.");
		this.name = name;
		this.color = color;
	}

	@Override
	public String toString() {
		return "	ID: " + this.getId() + "	NOMBRE: " + name + "	COLOR: " + color + "	PRECIO: " + this.getPrice();
	}
}
