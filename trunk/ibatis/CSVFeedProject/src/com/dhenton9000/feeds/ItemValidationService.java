package com.dhenton9000.feeds;

public interface ItemValidationService {

	
	
	/**
	 * This service will determine if a VO object should be 
	 * submitted to the service. That is, the object represents a row
	 * in the CSV file, and this checks to see if it will be written 
	 * It must have awareness of what to cast the object to
	 * @param item the VO object to validate, casting must
	 * be done by the implementation
	 * @return true if valid to insert into feed false if not
	 */
	public boolean validate(Object item);
}
