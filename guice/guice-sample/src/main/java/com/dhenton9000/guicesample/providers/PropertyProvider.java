/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.providers;

import com.google.inject.Provider;

public class PropertyProvider<T> implements Provider<T> {

    private final T value;

    public PropertyProvider(T value) {
        this.value = value;
    }

    @Override
    public T get() {
        return value;
    }
}