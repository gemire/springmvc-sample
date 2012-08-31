/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.test.exceptions.rollback;

import com.dhenton9000.test.exceptions.commit.*;

/**
 *
 * @author dhenton
 */
public class RollbackException extends Exception {

    public RollbackException(Throwable cause) {
        super(cause);
    }

    public RollbackException(String message, Throwable cause) {
        super(message, cause);
    }

    public RollbackException(String message) {
        super(message);
    }

    public RollbackException() {
    }
    
   
}
