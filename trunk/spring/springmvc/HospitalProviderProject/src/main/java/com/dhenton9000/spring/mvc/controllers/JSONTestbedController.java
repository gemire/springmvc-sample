/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.mvc.controllers;

import com.dhenton9000.neo4j.hospital.json.Division;
import com.dhenton9000.neo4j.hospital.json.TestBook;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public static final String RESULTS_KEY = "results";
  

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView showFormInInitialState() {

        return new ModelAndView(DESTINATION_TILE);

    }
    
     @RequestMapping(value = "doBook", 
             produces={"application/json"},
             consumes={"application/json"} ,
             method = {RequestMethod.POST})
    public @ResponseBody
    TestBook getTestBook(@RequestBody TestBook book) {
         log.debug("got book: "+book);
         book.setAuthor(book.getAuthor()+"XXX");
         return book;
    }
    
}
