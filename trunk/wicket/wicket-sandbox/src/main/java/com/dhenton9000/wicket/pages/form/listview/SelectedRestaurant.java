/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.form.listview;

import com.dhenton9000.jpa.entities.Restaurant;
import java.io.Serializable;

/**
 *
 * @author Don
 */
public class SelectedRestaurant implements Serializable {

    private Restaurant restaurant;
    private boolean selected;

    SelectedRestaurant(Restaurant r) {
        this.restaurant = r;
    }

    SelectedRestaurant(SelectedRestaurant s) {
        this.restaurant = s.getRestaurant();
    }

    public String getName() {
        return restaurant.getName();
    }

    public Integer getId() {
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
        final SelectedRestaurant other = (SelectedRestaurant) obj;
        return other.getRestaurant().equals(this.getRestaurant());
    }

    @Override
    public String toString() {
        return "CandidateRestaurant{" + "restaurant=" + restaurant + ", selected=" + this.isSelected() + '}';
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
