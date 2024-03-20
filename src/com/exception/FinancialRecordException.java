package com.exception;

public class FinancialRecordException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message;
	public FinancialRecordException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	

}
