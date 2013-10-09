/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.mvc.controllers.backbone;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dhenton
 */
@Controller
@RequestMapping(value = "/backbone/demos/*")
public class BasicBackboneController {

    @RequestMapping(value = "/{modelId}", method = RequestMethod.DELETE)
    public void deleteBasicModel(@PathVariable String modelId) {
        
        
        
    }
    
    @RequestMapping("/localstorage")
	public ModelAndView gotoJasonDemo() {
		 
		return new ModelAndView("tiles.backbone.demos.localstorage");
	}
    
}
