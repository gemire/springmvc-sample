/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.people;

/**
 *
 * @author Don
 */
public class MalePerson extends SimplePerson {

    public MalePerson(String n, int a, boolean r) {
        super(n, a, r);

    }

    @Override
    public String getName() {
        return "Mr. " + super.getName();
    }
}