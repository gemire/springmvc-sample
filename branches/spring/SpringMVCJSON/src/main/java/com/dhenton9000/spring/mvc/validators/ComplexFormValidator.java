package com.dhenton9000.spring.mvc.validators;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import com.dhenton9000.spring.mvc.model.FormBean;

public class ComplexFormValidator implements Validator {
	private static Logger log = LogManager
			.getLogger(ComplexFormValidator.class);

	public boolean supports(Class<?> candidate) {
		log.debug("class " + candidate.getCanonicalName());
		return FormBean.class.isAssignableFrom(candidate);

	}

	public void validate(Object target, Errors errors) {
		log.debug("validate called target " + target + " error count "
				+ errors.getErrorCount());
	//	log.debug("target class " + target.getClass().getName());

		FormBean form = (FormBean) target;
		String formName = form.getName();
		if (formName == null)
			formName = "";
		formName = formName.toUpperCase();
		String testName = form.getName();
		if (testName == null)
			testName = "";
		testName = testName.toUpperCase();
		Object[] vargs = new Object[1];
		vargs[0] = testName;
		log.debug("test name "+testName);
		if (formName.indexOf("BOZO") > -1) {

			
			//reject gives a global error
			errors.rejectValue("name", "nobozos.error", vargs,
					"default bozo error");
		}

	}

}
