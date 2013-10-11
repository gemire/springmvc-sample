package com.dhenton9000.spring.mvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.*;



@Controller
@RequestMapping("/getpostdemo/*")
public class GetPostController {
	
 
	private static Logger log = LogManager.getLogger(GetPostController.class);
	
	
	@RequestMapping(value="home",method=RequestMethod.GET) 
	public ModelAndView getPage() {
	 
		 
		return new ModelAndView("tiles.getpostdemo", "message", null);
	}
	 
	
	@RequestMapping(value="post",method=RequestMethod.POST) 
	public ModelAndView postPage() {
	 
		String message = "This came from a post";
		return new ModelAndView("tiles.getpostdemo", "message", message);
	}
	
	 
	
}
