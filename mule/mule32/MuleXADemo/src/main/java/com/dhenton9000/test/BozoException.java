/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.test;

/**
 *
 * @author dhenton
 */
public class BozoException extends RuntimeException {

    public BozoException(Throwable cause) {
        super(cause);
    }

    public BozoException(String message, Throwable cause) {
        super(message, cause);
    }

    public BozoException(String message) {
        super(message);
    }

    public BozoException() {
    }

    
    
}
