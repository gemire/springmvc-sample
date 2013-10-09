package com.dhenton9000.spring.mvc.controllers;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tags/demo/*")
public class TagController {

	public static final String TAG_TILES = "tiles.tag.demo";
	private static Logger log = LogManager.getLogger(TagController.class);

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView showInitial() {
		ArrayList<String> items = new ArrayList<String>();
		items.add("alpha");
		items.add("beta");
		items.add("gamma");
		return new ModelAndView(TAG_TILES,"items",items);

	}

}
