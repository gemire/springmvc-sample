package com.dhenton9000.spring.rest;

public class NumberParsingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 286182594420801885L;

	public NumberParsingException() {
		 
	}

	public NumberParsingException(String message) {
		super(message);
		 
	}

	public NumberParsingException(Throwable cause) {
		super(cause);
		 
	}

	public NumberParsingException(String message, Throwable cause) {
		super(message, cause);
		 
	}

	public NumberParsingException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		 
	}

}
