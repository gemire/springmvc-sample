package com.dhenton9000.spring.mvc.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

 //https://jira.springsource.org/browse/SPR-6817

import com.dhenton9000.spring.mvc.model.FormBean;
import com.dhenton9000.spring.mvc.validators.ComplexFormValidator;
//import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
@Controller
@RequestMapping("complex/forms/*")
@SessionAttributes("formBean")
public class ComplexFormController {

	public static final String COMPLEX_FORM_TILES = "tiles.complexforms";
	private static Logger log = LogManager
			.getLogger(ComplexFormController.class);
	public static final String FORMBEAN_KEY = "formBean";

	@Autowired
	private ComplexFormValidator validator;
// if you use this, it will override annotation based validation
//	@InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.setValidator(new ComplexFormValidator());
//    }

	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView showFormInInitialState() {

		return new ModelAndView(COMPLEX_FORM_TILES, FORMBEAN_KEY, new FormBean());

	}

	@RequestMapping(value = "addForm", method = RequestMethod.POST)
	public String addForm(@Valid @ModelAttribute("formBean") FormBean form, BindingResult result,
			WebRequest webRequest, HttpSession session, Model model) {

	 
		validator.validate(form,result);
		
		String destinationItem = COMPLEX_FORM_TILES;
		if (result.hasErrors())
		{
			//this is handy to get the property keys
			//in message.properties
			log.debug("ERRORS "+result.getAllErrors());
		}
		else
		{
			log.debug("success");
				 
		}
		
		return destinationItem;
	}

	public void setValidator(ComplexFormValidator validator) {
		this.validator = validator;
	}

	public ComplexFormValidator getValidator() {
		return validator;
	}

}
