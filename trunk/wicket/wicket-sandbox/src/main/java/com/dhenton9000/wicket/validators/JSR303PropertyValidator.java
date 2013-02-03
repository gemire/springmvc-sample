/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.validators;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.INullAcceptingValidator;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.ValidationError;

/**
 *http://carinae.net/2009/12/integration-of-jsr-303-bean-validation-standard-and-wicket-1-4/
 * @author dhenton
 */
public class JSR303PropertyValidator<T, Z> implements INullAcceptingValidator<T> {

    @SpringBean
    protected Validator validator;
    protected String propertyName;
    protected Class<Z> beanType;

    public JSR303PropertyValidator(Class<Z> clazz, String propertyName) {
        this.propertyName = propertyName;
        this.beanType = clazz;
        //injectDependencies();
    }

    @Override
    public void validate(IValidatable<T> validatable) {
        Set<ConstraintViolation<Z>> res = 
             this.validator.validateValue(this.beanType, 
             this.propertyName, validatable.getValue());
        
        for (ConstraintViolation<Z> vio : res) {
            validatable.error(new ValidationError().setMessage(vio.getMessage()));
        }
    }
}
