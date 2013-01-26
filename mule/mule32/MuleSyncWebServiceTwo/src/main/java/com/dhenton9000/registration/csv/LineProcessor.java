/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration.csv;

import com.dhenton9000.registration.bindings.RegisterInput;
import java.util.Map;

/**
 *
 * @author dhenton
 */
public interface LineProcessor {
    /**
     * process a single line and return the JAXB class to be sent
     * to the webservice
     * 
     * @param dataMap
     * @return jaxb object
     */
     RegisterInput processLine(Map<String, String> dataMap);
}
