package com.dhenton9000.spring.mvc.controllers;

import java.text.DateFormat;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;




@Controller
@RequestMapping("servlet/functions/*")
public class ServletFunctionsController {

	public static final String FUNCTIONS_DESTINATION_TILE = "tiles.servlet.functions";
	private static Logger log = LogManager.getLogger(ServletFunctionsController.class);

	
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String goHome()
	{
		return FUNCTIONS_DESTINATION_TILE;
	}
	
	
	@RequestMapping(value = "writeCookie", method = RequestMethod.GET)
	public String writeCookie(HttpServletRequest request, HttpServletResponse response)
	{
		
		java.util.Date dd = new java.util.Date();
		DateFormat dF = DateFormat.getDateInstance(DateFormat.FULL);
		String t = dF.format(dd);
		
		Cookie cookie = new Cookie("cookieKey", "cookieValue "+t);
		cookie.setMaxAge(60*60*24*365); // Store cookie for 1 year
		
		response.addCookie(cookie);
		
		
		return FUNCTIONS_DESTINATION_TILE;
	}

	@RequestMapping(value="parms/{parmId}", method=RequestMethod.GET)
	public String findOwner(@PathVariable String parmId, Model model) {
	  
	  model.addAttribute("parmId", parmId);  
	  return FUNCTIONS_DESTINATION_TILE;
	}

	@RequestMapping(value="requestParms", method=RequestMethod.GET)
	public String requestParms(@RequestParam("name") String name, @RequestParam("age") int age,Model model) {
	  String t = name+", your age in ten years will be "+(age + 10);
	  model.addAttribute("paramInfo", t);  
	  return FUNCTIONS_DESTINATION_TILE;
	}

	
}

 
 


