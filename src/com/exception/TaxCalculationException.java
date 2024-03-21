package com.exception;

public class TaxCalculationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public TaxCalculationException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}

