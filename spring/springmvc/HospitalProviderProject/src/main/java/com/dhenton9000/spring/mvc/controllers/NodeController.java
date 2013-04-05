/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.mvc.controllers;

import com.dhenton9000.spring.mvc.model.NodeFormBean;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dhenton
 */
@Controller
@RequestMapping("node/forms/*")
@SessionAttributes("nodeFormBean")
public class NodeController {

    public static final String COMPLEX_FORM_TILES = "tiles.node.edit";
    private static Logger log = LogManager.getLogger(NodeController.class);
    public static final String FORMBEAN_KEY = "nodeFormBean";

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView showFormInInitialState() {

        return new ModelAndView(COMPLEX_FORM_TILES, FORMBEAN_KEY, new NodeFormBean());

    }
    
    @RequestMapping(value = "nodeForm", method = RequestMethod.POST)
	public String addForm(@ModelAttribute("nodeFormBean") NodeFormBean form, 
        BindingResult result,
	WebRequest webRequest, HttpSession session, Model model) {
		log.info("form "+form.getName());
		String destinationItem = COMPLEX_FORM_TILES;
		return destinationItem;
	}
    
    
}
