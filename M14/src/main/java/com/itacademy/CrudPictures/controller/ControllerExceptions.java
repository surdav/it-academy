package com.itacademy.CrudPictures.controller;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.itacademy.CrudPictures.exceptions.FullShopException;

@RestControllerAdvice
public class ControllerExceptions {

	// The exception is thrown in case the store capacity is exceeded and return message error
	@ExceptionHandler(FullShopException.class)
	@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)  // 507
	public String misMatchException(FullShopException e) {
		return e.getMessage();
	}

}
