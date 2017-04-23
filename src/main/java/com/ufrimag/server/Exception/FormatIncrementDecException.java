package com.ufrimag.server.Exception;

public class FormatIncrementDecException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	String message;


	public String getMessage() {
		return message;
	}


	public FormatIncrementDecException(String message) {
		super();
		this.message = message;
	}
	
	
}
