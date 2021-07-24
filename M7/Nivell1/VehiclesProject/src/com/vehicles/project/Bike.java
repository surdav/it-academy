package com.vehicles.project;

public class Bike extends Vehicle {

	private Wheel frontWheel;
	private Wheel backWheel;

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}

	public void addWheels(Wheel frontWheel, Wheel backWheel) {
		this.frontWheel = frontWheel;
		this.backWheel = backWheel;
	}

	@Override
	public String toString() {
		return "Mi moto:\n" +
				"matricula: " + plate + ",\n" +
				"marca: " + brand + ", \n" +
				"color: " + color + ", \n" +
				"RUEDAS: " +
				"\n delantera: " + frontWheel +
				"\n trasera: " + backWheel;
	}

}
