package com.dhenton9000.spring.mvc.controllers.database;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/database/*")
public class BasicDatabaseController {

	private static Logger log = LogManager.getLogger(BasicDatabaseController.class);

	@RequestMapping(value = "simple/restaurant")
	public String goToSimpleRestaurants() {

		return "tiles.database.simple.restaurant";

	}
}
