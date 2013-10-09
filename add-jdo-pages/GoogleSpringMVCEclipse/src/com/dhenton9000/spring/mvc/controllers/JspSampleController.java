package com.dhenton9000.spring.mvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JspSampleController   {
	@RequestMapping("/jspSample")
	public ModelAndView jspSample() {
		String message = "This page was called via the InternalResourceViewResolver";
		return new ModelAndView("test/jspSampleResult", "message", message);
	}

	 
}
