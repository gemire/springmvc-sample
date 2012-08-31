/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration.csv;

/**
 *
 * @author dhenton
 */
 
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * This interface is for processing files for the wrapper system
 * 
 * @author dhenton
 * 
 */
public interface CsvProcessor {

	 
	/**
	 *  
	 * This function does not close the input stream parameter, that is<br>
	 * the responsibility of the calling function<br>
	 * 
	 * @param input
	 */
	void processInput(InputStream input);

        void setWebServiceTransmitter(WebServiceTransmitter t);
	 

}