/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.ersatzdb.generators;

import com.dhenton9000.ersatzdb.ErsatzGenerator;
import java.util.HashMap;
import java.util.List;

/**
 *
 */
public class CustomerGenerator<Customer> extends ErsatzGenerator {
    
    public CustomerGenerator(HashMap<String,List<String>> t)
    {
        super(t);
    }
}
