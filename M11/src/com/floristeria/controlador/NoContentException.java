package com.floristeria.controlador;

@SuppressWarnings("serial")
public class NoContentException extends Exception {
	
	public NoContentException() {}

	public NoContentException(String errorMessage) {
		super(errorMessage);
	}
}