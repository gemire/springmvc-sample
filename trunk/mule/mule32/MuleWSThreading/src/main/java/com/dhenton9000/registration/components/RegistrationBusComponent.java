/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration.components;

import com.dhenton9000.registration.bindings.RegisterInput;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author dhenton
 */
public class RegistrationBusComponent  {
        private static final  Logger logger = LogManager.getLogger(RegistrationBusComponent.class);

    public void processRegistration(RegisterInput input)
    {
        logger.info("@@@@@@@@@@@@@@@@ The bus component received a registration for  "+input.getName());
    }
}
