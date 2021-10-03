package com.floristeria.controlador;

@SuppressWarnings("serial")
public class WrongMaterialException extends Exception {
	
	public WrongMaterialException() {}
	
	public WrongMaterialException(String errorMessage) {
		super(errorMessage);
	}

}