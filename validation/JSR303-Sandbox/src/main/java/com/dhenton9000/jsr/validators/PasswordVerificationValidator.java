/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jsr.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author dhenton
 */
 
public class PasswordVerificationValidator implements ConstraintValidator<PasswordVerification, JSR303Sample>{
 
	@Override
	public void initialize(PasswordVerification constraintAnnotation) {
		// Nothing to do
	}
 
	@Override
	public boolean isValid(JSR303Sample value, ConstraintValidatorContext context) {
		if ( value.getPassword() == null && value.getPasswordVerification() == null ) {
			return true;
		}
		else if ( value.getPassword() == null ) {
			return false;
		}
		return ( value.getPassword().equals(value.getPasswordVerification()));
	}
 
}