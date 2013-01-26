/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration.csv;

import com.dhenton9000.registration.bindings.RegisterInput;

/**
 *
 * @author dhenton
 */
public interface WebServiceTransmitter {
        
        /**
         * send a RegisterInput request to a web service and return a 
         * TransmitResult which contains information about the communication
         * @param request the request to send
         * @param currentLine the linenumber that this transmission is derived from
         * @param the contents of the line as a String array
         * 
         * @return information about the success of the transmission
         */
	TransmitResult transmit(RegisterInput request, long currentLine,String[] lineContents);
}
