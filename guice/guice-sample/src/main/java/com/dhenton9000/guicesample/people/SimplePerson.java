/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.people;

/**
 *
 * @author Don
 */
public class SimplePerson implements Person {

    private String name = null;
    private int age = 0;
    private boolean republican = false;

    public SimplePerson(String n,int a,boolean r) {
        
        name = n;
        age = a;
        republican = r;
        
        
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean isRepublican() {
        return republican;
    }

    
    
    
}
