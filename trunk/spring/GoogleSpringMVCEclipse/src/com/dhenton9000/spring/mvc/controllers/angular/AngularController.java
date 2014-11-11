/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.mvc.controllers.angular;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.mvc.jdo.entities.RestaurantDTO;
import com.dhenton9000.spring.mvc.jdo.service.RestaurantService;

/**
 * 
 * @author dhenton
 */
@Controller
@RequestMapping(value = "/angular/*")
public class AngularController {

	 

	@RequestMapping("/restaurant")
	public ModelAndView gotoJasonDemo() {

		return new ModelAndView("tiles.angular.restaurant");
	}

	 
}
