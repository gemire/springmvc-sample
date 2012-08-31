/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.test;

/**
 *
 * @author Don
 */
public interface XADao {
    public boolean insertMessage(String message) throws Exception;
    public int getMessage(String message) throws Exception;
}
