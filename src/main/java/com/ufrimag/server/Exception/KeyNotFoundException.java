package com.ufrimag.server.Exception;

public class KeyNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String message;

	public KeyNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
