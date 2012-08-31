/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.people;

import com.google.inject.ImplementedBy;

/**
 *
 * @author Don
 */
@ImplementedBy(SimplePerson.class)
public interface Person {
    
    public String getName();
    public int getAge();
    public boolean isRepublican();
    
}
