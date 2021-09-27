package com.floristeria.modelo.dominio;

import java.text.Collator;

public class Decoracion extends Producto {

	private final String name;
	private final String type;

	public Decoracion(String name, String type, double price) throws Exception {
		super(price);
		if (name.isBlank()) throw new Exception("Debe introducir un nombre para la tienda.");
		this.name = name;

		Collator comparador = Collator.getInstance();
		comparador.setStrength(Collator.PRIMARY);
		
		if (!comparador.equals(type,"plastico") &&
			!comparador.equals(type, "madera")) {
			throw new Exception("La decoración sólo puede ser de madera o de plastico");
		}
		this.type = type;
	}

	@Override
	public String toString() {
		return "	ID: " + this.getId() + "	NOMBRE: " + name + "	TIPO: " + type + "	PRECIO: " + this.getPrice();
	}

}
