package com.dhenton9000.spring.rest.controllers;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dhenton9000.spring.mvc.jdo.service.impl.ValidatorFailureException;
import com.dhenton9000.spring.rest.NumberParsingException;




/**
 * This class is a general error handler and will be applied across all controllers
 * http://viralpatel.net/blogs/spring-mvc-exception-handling-controlleradvice-annotation/
 * @author dhenton
 *
 */
@ControllerAdvice
public class ControllerAdvisor {

	
	/**
	 * com.dhenton9000.spring.rest.controllers.BackboneRestaurantRestController.update(RestaurantDTO, String)
	 * will throw this Exception if the submitted
	 * @param v
	 * @return
	 */
	
	@ExceptionHandler
	@ResponseBody
	public ErrorResponseClass handleResourceNotFoundException(ValidatorFailureException v) {
		ErrorResponseClass response = new ErrorResponseClass(v); 
		String errorList = "";
		for (String key: v.getErrors().keySet())
		{
			errorList += "key: "+key+" "+v.getErrors().get(key)+",";
		}
		if (errorList.length()> 1)
		{
			errorList = errorList.substring(0,errorList.length()-1);
		}
		response.setMessage(errorList);
		return response;

	}
	
	
	/**
	 * This is for the BackboneRestaurantController which throws these whenever it can't parse
	 * an integer
	 * @param b
	 * @return
	 */
	@ExceptionHandler
	@ResponseBody
	public ErrorResponseClass handleResourceNotFoundException(NumberParsingException b) {
		ErrorResponseClass response = new ErrorResponseClass(b);
		return response;

	}
}
