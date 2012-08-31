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

	void transmit(RegisterInput request);
}
