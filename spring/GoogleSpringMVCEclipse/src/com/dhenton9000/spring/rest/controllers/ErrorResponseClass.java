package com.dhenton9000.spring.rest.controllers;

 

public class ErrorResponseClass {

	private String message;
	private String errorClass;
	public ErrorResponseClass(Throwable b) {
		 message = b.getMessage();
		 errorClass = b.getClass().getName();
	}
	public ErrorResponseClass() {
		 
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the errorClass
	 */
	public String getErrorClass() {
		return errorClass;
	}
	/**
	 * @param errorClass the errorClass to set
	 */
	public void setErrorClass(String errorClass) {
		this.errorClass = errorClass;
	}
	
}