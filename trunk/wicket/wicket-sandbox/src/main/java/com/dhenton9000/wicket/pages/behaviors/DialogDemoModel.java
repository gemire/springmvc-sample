/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.behaviors;

import java.io.Serializable;

/**
 *
 * @author dhenton
 */
public class DialogDemoModel implements Serializable{
    
    
    
    
    private String name = null;
    private int age = 0;
    private String occupation = null; // drop down box
    
    
    public DialogDemoModel()
    {
        
    }
    
    public DialogDemoModel(String name, int age, String occupation)
    {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
    
    
    
    
    
}
