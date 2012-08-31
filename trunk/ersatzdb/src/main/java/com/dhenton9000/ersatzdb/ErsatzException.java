/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.ersatzdb;

/**
 *
 */
public class ErsatzException extends RuntimeException {

    public ErsatzException(Throwable cause) {
        super(cause);
    }

    public ErsatzException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErsatzException(String message) {
        super(message);
    }

    public ErsatzException() {
    }
    
}
