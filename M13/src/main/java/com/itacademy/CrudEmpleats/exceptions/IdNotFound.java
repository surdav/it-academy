package com.itacademy.CrudEmpleats.exceptions;

public class IdNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final int id;

	public IdNotFound(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
