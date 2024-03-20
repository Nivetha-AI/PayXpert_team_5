package com.exception;

public class ValidationException extends Exception{

	private static final long serialVersionUID = 1L;
	String message;
	public ValidationException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	

}
