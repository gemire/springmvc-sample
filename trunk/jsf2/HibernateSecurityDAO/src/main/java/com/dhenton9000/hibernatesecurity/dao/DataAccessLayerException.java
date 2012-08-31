/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.hibernatesecurity.dao;

/**
 *
 * @author dyh
 */
public class DataAccessLayerException extends Exception {

    public DataAccessLayerException(String s)
    {
        super(s);
    }

    public DataAccessLayerException(Exception t)
    {
        super(t);
    }

}
