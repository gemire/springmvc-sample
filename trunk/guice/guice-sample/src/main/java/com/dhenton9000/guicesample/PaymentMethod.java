/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample;

import com.google.inject.ImplementedBy;

/**
 * The Implemented by Annotation says which concrete implementation to use
 * for this interface
 * @author dhenton
 */
 @ImplementedBy(PayWithCreditCard.class)
public interface PaymentMethod {
   
    public String pay(int amount);
}
