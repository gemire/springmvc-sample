package com.dhenton9000.spring.mvc.controllers;

import javax.annotation.security.RolesAllowed;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("security/demo/*")
public class SecurityController {

	public static final String SECURITY_TILES = "tiles.security.demo";
	private static Logger log = LogManager.getLogger(SecurityController.class);

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String showInitial() {

		return SECURITY_TILES;

	}

	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String showAdmin() {

		return "tiles.security.admin";

	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String showLogout() {

		return "tiles.security.logout";

	}

	@RequestMapping(value = "denied", method = RequestMethod.GET)
	public String showDenied() {

		return "tiles.security.denied";

	}
	
	@RolesAllowed("ROLE_ADMIN")
	@RequestMapping(value = "special/admin", method = RequestMethod.GET)
	public String showSpecialAdmin() {

		return "tiles.security.special.admin";

	}
	
	
}
