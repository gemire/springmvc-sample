/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.utils.velocityproject;

import java.util.ArrayList;

/**
 *
 * @author dhenton
 */
public class Item {
    private String name = null;
    private int age = 0;
    private ArrayList properties = null;

    public Item() {
    }

    public Item(String s, int i) {
        name = s;
        age = i;
    }

    
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    
    public ArrayList getProperties()
    {
        if (properties == null)
        {
            properties = new ArrayList();
            properties.add("Name");
            properties.add("Garbage");
        }
        
        return properties;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", age=" + age + '}';
    }
    
    
    
}
