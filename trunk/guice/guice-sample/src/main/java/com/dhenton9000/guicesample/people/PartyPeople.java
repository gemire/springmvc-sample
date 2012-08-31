/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.people;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.Set;

/**
 *
 * @author Don
 */
public class PartyPeople {
    private final Set<Person> group1;
    
    public Set<Person> getGroup1() {
        return group1;
    }

    public Set<Person> getGroup2() {
        return group2;
    }
    private final Set<Person> group2;
    
    @Inject
    public PartyPeople(@Named("boring") Set<Person> g1, @Named("cool") Set<Person> g2)
    {
        this.group1 = g1;
        this.group2 = g2;
    }
    
}
