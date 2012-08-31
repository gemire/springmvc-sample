/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.hibernatesecurity;

/**
 *
 * @author dyh
 */
public class Utils {

   public static final String createErrorMessage(Exception e)
    {
        return "error class: " + e.getClass().getName() + " " + e.getMessage();
    }

}
