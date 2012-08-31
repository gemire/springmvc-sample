/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.inject.provider;

/**
 *
 * @author dhenton
 */
public class InjectedClass {
    private String message = null;
    
    public void setMessage(String t){ message = t;}
    public String getMessage(){return message;}
    
    public InjectedClass(String t)
    {
        message = t;
    }
    
    public InjectedClass(){}
}
