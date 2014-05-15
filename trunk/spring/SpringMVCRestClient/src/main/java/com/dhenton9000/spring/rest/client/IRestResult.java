/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.spring.rest.client;

/**
 *
 * @author dhenton
 * @param <T>
 */
public interface IRestResult<T> {
    
    public T getPayload();
    public ErrorClass getError();
    public void setError(ErrorClass e);
    public void setPayload(T p);
}
