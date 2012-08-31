package com.dhenton9000.hibernatetest.dataaccess;

public class DataAccessLayerException extends Exception {

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
