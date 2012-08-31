/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.annotations;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.google.inject.BindingAnnotation;
/**
 *
 * @author dhenton
 */


@Retention(RUNTIME)
@Target( {
   ElementType.FIELD, ElementType.PARAMETER
})
@BindingAnnotation
public @interface PropertyAnnotation {
    
   public String value();
}



