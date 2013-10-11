package com.dhenton9000.validator.tests;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
//http://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#table-builtin-constraints
public class ValidatorTestCase {
	private static final Logger log = LogManager.getLogger(ValidatorTestCase.class);
	
	@Test
	public void testValidator() {

		Email email = new Email();
		email.setFrom("johndomain.com");
		email.setTo("someone");
		email.setSubject("");
		email.setBody(null);
		
		PersonalInfo  pInfo = new PersonalInfo();
		pInfo.setAge(12);
		pInfo.setPhone("(415) 555 4545");
		pInfo.setGender("M");
		email.setPersonalInformation(pInfo);
		
		ValidatorFactory validatorFactory = Validation
				.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Email>> violations = validator.validate(email);
		int c = 0;
		for (ConstraintViolation<Email> violation : violations) {
			String propertyPath = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			log.debug("invalid value for: '" + propertyPath + "': "
					+ message);
			c++;
		}
		
		
		assertTrue(violations.size() > 0);
	 
		 
		
		
		

	}

}
