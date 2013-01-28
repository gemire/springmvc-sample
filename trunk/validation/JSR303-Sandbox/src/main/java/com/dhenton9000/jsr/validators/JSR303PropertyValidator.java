/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jsr.validators;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
 

/**
 *http://carinae.net/2009/12/integration-of-jsr-303-bean-validation-standard-and-wicket-1-4/
 * @author dhenton
 */
public class JSR303PropertyValidator<T, Z>   {

    
    protected Validator validator;
    protected String propertyName;
    protected Class<Z> beanType;
  //  this.validator.validateValue(this.beanType, 
  //           this.propertyName, validatable.getValue());
    

   
}
