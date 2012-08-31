/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample;

/**
 *
 * @author dhenton
 */
public class PayWithCash extends AbstractPayment {
    
   
    private String methodName = "Cash";

    @Override
    public String getMethod() {
        return methodName;
    }

   

    

    
}
