/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.springobserver;

/**
 *
 * @author dhenton
 */
public interface Subject {
  public void addListener(Observer o);
  public void removeListener(Observer o);
  public void notifyListeners();
}

