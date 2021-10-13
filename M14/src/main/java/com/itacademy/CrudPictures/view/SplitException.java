package com.itacademy.CrudPictures.view;

public class SplitException {

	// transform the error to split code and message to show on the website.
	public String[] Split(Exception ex) {
		String[] errorSplit = ex.getMessage().split(":");
		
		errorSplit[1] = errorSplit[1].replace("[", "");
		errorSplit[1] = errorSplit[1].replace("]", "");
		return errorSplit;
	}

	
}
