package com.floristeria.modelo.dominio;

import com.floristeria.controlador.NoContentException;
import com.floristeria.controlador.WrongMaterialException;

public class Decoracion extends Producto {

	private final String name;
	private final Material type;

	public Decoracion(String name, Material type, double price) throws NoContentException, WrongMaterialException {
		super(price);
		if (name.isBlank()) throw new NoContentException("Debe introducir un nombre para la decoraci�n.");
		this.name = name;

		if(!type.equals(Material.PLASTICO) && !type.equals(Material.MADERA))
			throw new WrongMaterialException("La decoraci�n s�lo puede ser de madera o de plastico");
			
		this.type = type;
	}
	
	public enum Material {
		MADERA, PLASTICO;	// Las decoraciones �nicamente pueden ser de madera o de pl�stico
	}

	@Override
	public String toString() {
		return "	ID: " + this.getId() + "	NOMBRE: " + name + "	TIPO: " + type + "	PRECIO: " + this.getPrice();
	}

}
