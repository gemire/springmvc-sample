/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.spring.rest.client.results;

import com.dhenton9000.spring.rest.client.ErrorClass;
import com.dhenton9000.spring.rest.client.IRestResult;

/**
 * A generic return object that wraps the result of interest
 * @author dhenton
 * @param <T> the underlying payload class e.g. Restaurant
 */
public class GenericResultObject<T> implements IRestResult<T>  {

    private ErrorClass errorClass;

    private T payload;
    @Override
    public T getPayload() {
         return payload;
    }

    @Override
    public ErrorClass getError() {
         return errorClass;
    }

    @Override
    public void setError(ErrorClass e) {
        errorClass = e;
    }

    @Override
    public void setPayload(T p) {
         payload = p;
    }
    
    
}
