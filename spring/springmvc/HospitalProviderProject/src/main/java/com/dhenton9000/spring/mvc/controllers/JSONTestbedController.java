/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.mvc.controllers;

import com.dhenton9000.neo4j.hospital.json.Division;
import com.dhenton9000.neo4j.hospital.json.JSONHospitalService;
import com.dhenton9000.neo4j.hospital.json.TestBook;
import com.dhenton9000.spring.mvc.model.NodeFormBean;
import javax.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dhenton
 */
@Controller
@RequestMapping("json/testbed/*")
public class JSONTestbedController {

    private static Logger log = LogManager.getLogger(JSONTestbedController.class);
    public static final String DESTINATION_TILE = "tiles.json.testbed";
    public static final String PARENT_ID_KEY = "parentInfo";
    public static final String BEAN_NAME = "nodeFormBean";
    @Autowired
    private JSONHospitalService jService;
 
 
 
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView showFormInInitialState() {

        return new ModelAndView(DESTINATION_TILE);

    }

    @RequestMapping(value = "doBook",
    produces = {"application/json"},
    consumes = {"application/json"},
    method = {RequestMethod.POST})
    public @ResponseBody
    TestBook getTestBook(@RequestBody TestBook book) {
        log.debug("got book: " + book);
        book.setAuthor(book.getAuthor() + "XXX");
        return book;
    }

    @RequestMapping(value = "maintainNode", method = RequestMethod.POST)
    public ModelAndView maintainNode(@ModelAttribute(BEAN_NAME) 
            NodeFormBean form,
            BindingResult result,
            WebRequest webRequest, HttpSession session, Model model) {
        log.info("maintainNode " + form.getName());
        DivInfo d = new DivInfo();
        d.id="maintain";
        return new ModelAndView(DESTINATION_TILE,PARENT_ID_KEY,d);
    }

    @RequestMapping(value = "{name}/createTree", method = RequestMethod.GET)
    public @ResponseBody
    Division createTree(@PathVariable String name){
        log.debug("name is "+name);
        Division div = new Division();
        div.setName(name);
        Division newDiv = jService.attachFullTree(div);
        return newDiv;
    }

    /**
     * @return the jService
     */
    public JSONHospitalService getjService() {
        return jService;
    }

    /**
     * @param jService the jService to set
     */
    public void setjService(JSONHospitalService jService) {
        this.jService = jService;
    }
    
    
    public class DivInfo
    {
        private String id = null;

        /**
         * @return the id
         */
        public String getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(String id) {
            this.id = id;
        }
        
                
    }
    
    
    
}
