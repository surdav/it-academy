package com.itacademy.CrudEmpleats.controller;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.itacademy.CrudEmpleats.exceptions.IdNotFound;

@RestControllerAdvice
public class ControllerExceptions {

	// Excepción si no se introduce un integer al id de la petición.
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.PRECONDITION_FAILED) // 412
	public String misMatchException(MethodArgumentTypeMismatchException e) {
		return "<h1>Error!</h1>" + "El parametro <strong>" + e.getName() + " = " + e.getValue() + "</strong>"
				+ " tiene que ser del tipo <strong>" + e.getRequiredType() + "</strong>.";
	}

	// Excepción si no se encuentra el elemento solicitado.
	@ExceptionHandler(IdNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND) // 404
	public String noSuchElementException(IdNotFound e) {
		return "<h1>Error!</h1>" + "No se encontró ningún empleado con el ID: " + e.getId();
	}

	// Filtro por errores no controlados con información para mejorar la aplicación.
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.CONFLICT) // 409
	public String exceptionHandeler(Exception e) {
		return "<h1>Error!</h1>" + "Tipo: " + e.getClass() + "<br>" + "Mensaje Error: " + e.getMessage();
	}
}
