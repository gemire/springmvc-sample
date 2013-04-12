/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.mvc.controllers;

import com.dhenton9000.neo4j.hospital.json.Division;
import com.dhenton9000.neo4j.hospital.json.HospitalNode;
import com.dhenton9000.neo4j.hospital.service.HospitalService;
import com.dhenton9000.spring.mvc.model.NodeFormBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * node/forms/json/sendDivision
 *
 * @author dhenton
 */
@Controller
@RequestMapping("node/forms/*")
@SessionAttributes("nodeFormBean")
public class NodeController {

    private static Logger log = LogManager.getLogger(NodeController.class);
    public static final String FORMBEAN_KEY = "nodeFormBean";
    public static final String DESTINATION_TILE = "tiles.node.edit";
    public static final String RESULTS_KEY = "results";
    @Autowired
    private HospitalService jService;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView showFormInInitialState() {

        return new ModelAndView(DESTINATION_TILE, FORMBEAN_KEY,
                new NodeFormBean());

    }

    //TODO: add a node to the current node then refresh the tree via ajax
    //the form will need to submit the new info and the id of the parent
    //delete the current node
    //edit the current node
    @RequestMapping(value = "nodeForm", method = RequestMethod.POST)
    public String addForm(@ModelAttribute("nodeFormBean") NodeFormBean form,
            BindingResult result,
            WebRequest webRequest, HttpSession session, Model model) {
        log.info("form " + form.getName());
        String destinationItem = DESTINATION_TILE;
        return destinationItem;
    }

    @RequestMapping(value = "{name}/sendDivisionTwo", 
            produces={"application/json"},
            consumes={"application/json"} ,
            method = RequestMethod.POST)
    public @ResponseBody
    Division sendDivisionTwo(@PathVariable String name,
    @RequestBody Division divIN) {
        log.debug("div name "+divIN.getName());
        divIN.setName(divIN.getName() + name);
        return divIN;
    }



    /**
     * @return the jService
     */
    public HospitalService getjService() {
        return jService;
    }

    /**
     * @param jService the jService to set
     */
    public void setjService(HospitalService jService) {
        this.jService = jService;
    }
}
