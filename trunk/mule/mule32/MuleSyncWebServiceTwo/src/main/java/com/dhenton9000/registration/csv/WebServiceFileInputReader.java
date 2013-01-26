/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration.csv;

/**
 *
 * @author Don
 */


import java.io.InputStream;

/**
 * This interface is for processing files 
 * 
 * @author dhenton
 * 
 */
public interface WebServiceFileInputReader  {

	

	/**
	 * This function does not close the input stream parameter, that is<br>
	 * the responsibility of the calling function<br>
	 * 
	 * @param input
	 */
	void processInput(InputStream input);

	void setWebServiceTransmitter(WebServiceTransmitter t);

	

}
