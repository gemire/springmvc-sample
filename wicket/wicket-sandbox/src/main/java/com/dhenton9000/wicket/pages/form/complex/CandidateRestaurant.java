/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.wicket.pages.form.complex;

import com.dhenton9000.jpa.entities.Restaurant;
import java.io.Serializable;
/**
 *
 * @author Don
 */
public class CandidateRestaurant implements Serializable{


   public enum ROLE_TYPE   {Basic, Advanced};
    
    private Restaurant restaurant;
    private ROLE_TYPE  roleType = ROLE_TYPE.Basic;
    

    CandidateRestaurant(Restaurant r) {
         this.restaurant = r;
    }

    
    public String getName()
    {
        return restaurant.getName();
    }
    
    public Integer getId()
    {
        return restaurant.getId();
    }
    
    
    /**
     * @return the restaurant
     */
    public Restaurant getRestaurant() {
        return restaurant;
    }

    /**
     * @param restaurant the restaurant to set
     */
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    /**
     * @return the roleType
     */
    public ROLE_TYPE getRoleType() {
        return roleType;
    }

    /**
     * @param roleType the roleType to set
     */
    public void setRoleType(ROLE_TYPE roleType) {
        this.roleType = roleType;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.restaurant != null ? this.restaurant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CandidateRestaurant other = (CandidateRestaurant) obj;
        if (this.restaurant != other.restaurant && (this.restaurant == null || !this.restaurant.equals(other.restaurant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CandidateRestaurant{" + "restaurant=" + restaurant + ", roleType=" + roleType   + '}';
    }
    
    
    
    
}
