/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.springdemos;

/**
 * This class is used for demonstrating how to call a method in a spring
 * bean with multiple arguments
 * @author dhenton
 */
public class MultiCall {
    
    private String p1 = "a";
    private String p2 = "b";
    
    public void set(String a1, String a2)
    {
        p1 = a1;
        p2 = a2;
    }
    
    public String speak()
    {
        return p1 + p2;
    }
}
