/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.spring.rest.client;

/**
 *
 * @author dhenton
 */
public class ErrorClass {
    private String message;
    private String errorClass;

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the errorClass
     */
    public String getErrorClass() {
        return errorClass;
    }

    /**
     * @param errorClass the errorClass to set
     */
    public void setErrorClass(String errorClass) {
        this.errorClass = errorClass;
    }
    
}
