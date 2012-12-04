/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.validators;

import java.io.Serializable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.wicket.validation.IErrorMessageSource;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidationError;
import org.apache.wicket.validation.IValidator;

/**
 * A validator for scrubbing HTML
 *
 * @author dhenton
 */
public class NoHTMLValidator implements IValidator {

    @Override
    public void validate(IValidatable validatable) {

        String data = "";
        Pattern pattern = Pattern.compile(".*<[-\\w]+[^>]+>.*", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(data);
        if (matcher.matches()) {
            validatable.error(new NoHTMLError());
        }

    }
    
    
    public class NoHTMLError implements IValidationError
    {

        @Override
        public Serializable getErrorMessage(IErrorMessageSource messageSource) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    public class ErrorMessageSource implements IErrorMessageSource
    {

        @Override
        public String getMessage(String key, Map<String, Object> vars) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    
}
