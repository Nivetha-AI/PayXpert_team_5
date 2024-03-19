package com.exception;

public class PayrollGenerationException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public PayrollGenerationException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
