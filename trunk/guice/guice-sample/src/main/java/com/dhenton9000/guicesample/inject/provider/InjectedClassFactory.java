/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.inject.provider;

import com.google.inject.Provider;

/**
 *
 * @author dhenton
 */
public class InjectedClassFactory implements Provider<InjectedClass> {

    public InjectedClass get() {
        return new InjectedClass("get a job on "+(new java.util.Date()));
    }
    
}
