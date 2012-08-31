package com.dhenton9000.classic.generic.dao;

public class DataAccessLayerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3879203161494366946L;

	public DataAccessLayerException() {
		 
	}

	public DataAccessLayerException(String message) {
		super(message);
		 
	}

	public DataAccessLayerException(Throwable cause) {
		super(cause);
		 
	}

	public DataAccessLayerException(String message, Throwable cause) {
		super(message, cause);
		 
	}

}
