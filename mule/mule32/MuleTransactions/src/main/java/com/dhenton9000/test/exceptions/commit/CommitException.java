/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.test.exceptions.commit;

/**
 *
 * @author dhenton
 */
public class CommitException extends Exception {

    public CommitException(Throwable cause) {
        super(cause);
    }

    public CommitException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommitException(String message) {
        super(message);
    }

    public CommitException() {
    }
    
   
}
