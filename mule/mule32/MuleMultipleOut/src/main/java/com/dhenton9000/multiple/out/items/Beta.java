/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.multiple.out.items;

/**
 *
 * @author dhenton
 */
public class Beta implements ItemInterface {

    private String message = null;
    private String prefix = "Beta says '";

    public Beta(String in) {
        message = in;
    }

    public Beta() {
    }

    @Override
    public String getMessage() {
        return prefix + message + "'!!!";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alpha other = (Alpha) obj;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public String toString() {
        return "Beta{" + "message=" + message + '}';
    }

    /**
     * @param message the message to set
     */
    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
