/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.spring.rest.client;

/**
 *
 * @author dhenton
 * @param <T> the underlying payload class e.g. Restaurant
 */
public class GenericExtractor<T> implements IRestResult<T>  {

    private ErrorClass errorClass = new ErrorClass();

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
