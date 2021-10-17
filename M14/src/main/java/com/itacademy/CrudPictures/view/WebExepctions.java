package com.itacademy.CrudPictures.view;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpServerErrorException;

@ControllerAdvice
public class WebExepctions {
	
	// handler the error exeception when post more pictures to full shop.
	@ExceptionHandler(HttpServerErrorException.class)
	public String fullShopApiError(@RequestBody HttpServerErrorException ex, Model model) {
		SplitException splitException = new SplitException();
		String[] errorSplit = splitException.Split(ex);
		model.addAttribute("errorCode",errorSplit[0]);	
		model.addAttribute("errorMessage",errorSplit[1]);
		return "shopError";
	}

}