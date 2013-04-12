/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.mvc.controllers;

import com.dhenton9000.neo4j.hospital.service.HospitalService;
import com.dhenton9000.spring.mvc.model.NodeFormBean;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    private HospitalService jService;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView showFormInInitialState() {

        return new ModelAndView(DESTINATION_TILE);

    }

//    @RequestMapping(value = "doBook",
//    produces = {"application/json"},
//    consumes = {"application/json"},
//    method = {RequestMethod.POST})
//    public @ResponseBody
//    TestBook getTestBook(@RequestBody TestBook book) {
//        log.debug("got book: " + book);
//        book.setAuthor(book.getAuthor() + "XXX");
//        return book;
//    }
    @RequestMapping(value = "maintainNode", method = RequestMethod.POST)
    public ModelAndView maintainAddNode(@RequestParam(required = true, 
            value = "submit") String submitFlag,
            @ModelAttribute(BEAN_NAME) NodeFormBean form) {
        log.info("maintainAddNode " + form.getName());
        log.info("submit is " + submitFlag);
        DivInfo d = new DivInfo();
        d.id = "maintain";
                d.setName(form.getName());
                d.setType(form.getType());;
       
        return new ModelAndView(DESTINATION_TILE, PARENT_ID_KEY, d);
    }


    @RequestMapping(value = "createTree", method = RequestMethod.POST)
    public ModelAndView createTree(@ModelAttribute(BEAN_NAME) NodeFormBean form,
            BindingResult result,
            WebRequest webRequest, HttpSession session, Model model) {
        log.info("createTree " + form.getName());

        return new ModelAndView(DESTINATION_TILE);
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

    public class DivInfo {

        private String id = null;
        private String type = null;
        private String name = null;

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

        /**
         * @return the type
         */
        public String getType() {
            return type;
        }

        /**
         * @param type the type to set
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }
        
        
        
        
    }
}
