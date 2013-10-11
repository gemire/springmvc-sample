package com.dhenton9000.spring.mvc.exceptions;

public class BozoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6503220161771483997L;

	public BozoException() {
		 
	}

	public BozoException(String message) {
		super(message);
		 
	}

	public BozoException(Throwable cause) {
		super(cause);
		 
	}

	public BozoException(String message, Throwable cause) {
		super(message, cause);
	 
	}

}
