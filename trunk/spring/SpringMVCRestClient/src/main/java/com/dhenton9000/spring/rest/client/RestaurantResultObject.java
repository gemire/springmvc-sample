/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.rest.client;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;

/**
 *
 * @author dhenton
 *  
 */
public class RestaurantResultObject  implements IRestResult<Restaurant>

{

    private Restaurant normalPayload;
    private ErrorClass error;

    /**
     * @return the normalPayload
     */
    @Override
    public Restaurant getPayload() {
        return normalPayload;
    }

    /**
     * @param normalPayload the normalPayload to set
     */
    @Override
    public void setPayload(Restaurant normalPayload) {
        this.normalPayload = normalPayload;
    }

    /**
     * @return the error
     */
    @Override
    public ErrorClass getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    @Override
    public void setError(ErrorClass error) {
        this.error = error;
    }

    

}
