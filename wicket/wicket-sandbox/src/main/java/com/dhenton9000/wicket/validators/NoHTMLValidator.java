/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A validator for HTML, right now the 
 * test would be the entire entry is '<html>'
 *
 * @author dhenton
 */
public class NoHTMLValidator implements IValidator {

    private Logger logger = LoggerFactory.getLogger(NoHTMLValidator.class);
    private final Pattern pattern;
    
    public NoHTMLValidator()
    {
        pattern = Pattern.compile("<(\"[^\"]*\"|'[^']*'|[^'\">])*>");
    }
    
    @Override
    public void validate(IValidatable validatable) {

        String data = validatable.getValue().toString();
        logger.debug("this data is "+data);
        Matcher matcher = pattern.matcher(data);
        if (matcher.matches()) {
            logger.debug("hit match");
            error(validatable, "no.html");
        }

    }
    
    
    
   // this entry should be in the message properties file
   // NoHTMLValidator.no.html=No html characters allowed in ${label}
    
    private void error(IValidatable<String> validatable, String errorKey) {
		ValidationError error = new ValidationError();
		error.addKey(getClass().getSimpleName() + "." + errorKey);
		validatable.error(error);
	}
}
