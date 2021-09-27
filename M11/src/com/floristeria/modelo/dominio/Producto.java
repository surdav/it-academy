package com.floristeria.modelo.dominio;

public abstract class Producto {

	private final int id;
	private static int next_id = 0;
	
	private final double price;
	
	public Producto(double price) {
		id = next_id++;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	
	public double getPrice() {
		return price;
	}
}
