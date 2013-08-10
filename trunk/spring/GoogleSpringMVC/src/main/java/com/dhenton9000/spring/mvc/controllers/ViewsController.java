package com.dhenton9000.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/views/*")
public class ViewsController {

	/**
	 * 
	 * @param model
	 * @return a string that maps to a view aka tile
	 */
	@RequestMapping(value="html", method=RequestMethod.GET)
	public String prepare(Model model) {
		model.addAttribute("foo", "bar");
		model.addAttribute("fruit", "apple");
		return "tiles.simple.view";
	}
	@RequestMapping(value="nontile", method=RequestMethod.GET)
	public String nonTile(Model model) {
		 
		return "tiles.nontiles";
	}
	
	/**
	 * this will not work with tiles it appears that the controller
	 * needs to return the view name
	 * @param model
	 */
	@RequestMapping(value="/viewByName", method=RequestMethod.GET)
	public void usingRequestToViewNameTranslator(Model model) {
		model.addAttribute("foo", "bar");
		model.addAttribute("fruit", "apple");
		 
		 
	}

}
