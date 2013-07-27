package com.dhenton9000.spring.mvc.controllers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dhenton9000.spring.mvc.exceptions.BozoException;
import com.dhenton9000.spring.mvc.model.Contact;
import com.dhenton9000.spring.mvc.model.ErrorInfo;

@Controller
@RequestMapping("errors/demo/*")
public class ErrorsDemoController {

	private static final String INFO_KEY = "resultMessage";
	public static final String ERROR_TILES = "tiles.errorsdemo";
	private static Logger log = LogManager
			.getLogger(ErrorsDemoController.class);
	private static final String ERROR_OBJ_KEY = "errorInfo";

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView errorHomePage() {

		return new ModelAndView(ERROR_TILES, ERROR_OBJ_KEY, new ErrorInfo());

	}

	@RequestMapping(value = "submitError", method = RequestMethod.POST)
	public ModelAndView submitError(
			@ModelAttribute(ERROR_OBJ_KEY) ErrorInfo errorInfo,
			BindingResult result) throws BozoException {

		String testName = errorInfo.getErrorValue();
		if (testName == null)
			testName = "";
		testName = testName.toUpperCase();

		log.debug("test name " + testName);
		if (testName.indexOf("BOZO") > -1) {

			throw new BozoException("You cannot be a bozo!");

		}
		ModelAndView mV = new ModelAndView(ERROR_TILES, INFO_KEY,
				"You are not a bozo!");
		return mV;
	}

	@ExceptionHandler
	public ModelAndView handleBozoError(BozoException b) {

		ModelAndView mV = new ModelAndView("tiles.errorsdisplay", INFO_KEY,
				"FROM ERROR HANDLER: "+b.getMessage());
		return mV;

	}

}