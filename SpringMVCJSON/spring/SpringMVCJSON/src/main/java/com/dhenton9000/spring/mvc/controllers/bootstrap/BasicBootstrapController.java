package com.dhenton9000.spring.mvc.controllers.bootstrap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Bootstrap demonstation controller
 *
 */



@Controller
@RequestMapping(value = "/bootstrap/demos/*")
public class BasicBootstrapController {

		
	private static Logger log = LogManager
			.getLogger(BasicBootstrapController.class);

	@RequestMapping(value = "tabledemo")
	public String goToTableDemo() {

		return "tiles.bootstrap.tabledemo";

	}

	 
}
