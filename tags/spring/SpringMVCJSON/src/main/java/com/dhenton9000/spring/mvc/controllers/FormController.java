package com.dhenton9000.spring.mvc.controllers;

import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dhenton9000.spring.mvc.model.Contact;
import com.dhenton9000.spring.mvc.model.ValidateBean;

@Controller
@RequestMapping("forms/*")
@SessionAttributes("contact")
public class FormController {

	public static final String FORMS_DESTINATION_TILE = "tiles.forms.demo";
	public static final String CONTACT_KEY = "contact";
	private static Logger log = LogManager
	.getLogger(FormController.class);

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView showFormInInitialState() {

		return new ModelAndView(FORMS_DESTINATION_TILE, CONTACT_KEY,
				new Contact());

	}

	@RequestMapping(value = "addContact", method = RequestMethod.POST)
	public String addContact(@ModelAttribute(CONTACT_KEY) Contact contact,
			BindingResult result) {
		log.debug("First Name: " + contact.getFirstname()
				+ " Last Name: " + contact.getLastname());
		if (contact != null)
		{
			contact.setFirstname("** "+contact.getFirstname());
		}
		return FORMS_DESTINATION_TILE;
	}
	
	//requires JSR 303 compliant validator on class path
	
	@RequestMapping("validate")
	public ModelAndView validate(@Valid ValidateBean bean, BindingResult result) {
		ModelAndView  mV = new ModelAndView(FORMS_DESTINATION_TILE);
		String info = null;
		if (result.hasErrors()) {
			info =  "Object has validation errors";
		} else {
			info = "No errors";
		}
		log.debug("info "+info);
		mV.addObject("errors", info);
		return mV;
	}
	

}
