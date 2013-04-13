/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.mvc.controllers;

import com.dhenton9000.neo4j.hospital.json.HospitalServiceException;
import com.dhenton9000.neo4j.hospital.service.HospitalService;
import com.dhenton9000.spring.mvc.model.FormBean;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dhenton
 */
@Controller
@RequestMapping("json/testbed/*")
@SessionAttributes({"createTreeFormBean", "maintainTreeFormBean","treeData"})
public class JSONTestbedController {

    private static Logger log = LogManager.getLogger(JSONTestbedController.class);
    public static final String DESTINATION_TILE = "tiles.json.testbed";
    public static final String TREE_DATA_KEY = "treeData";
    public static final String MAINTAIN_BEAN_NAME = "maintainTreeFormBean";
    public static final String CREATE_TREE_BEAN_NAME = "createTreeFormBean";
    @Autowired
    private HospitalService jService;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView showFormInInitialState() {

        HashMap map = new HashMap<String, Object>();
        map.put(MAINTAIN_BEAN_NAME, new FormBean());
        map.put(CREATE_TREE_BEAN_NAME, new FormBean());
        map.put(TREE_DATA_KEY, "");
        return new ModelAndView(DESTINATION_TILE, map);

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
            @ModelAttribute(MAINTAIN_BEAN_NAME) FormBean form) {
        log.info("maintainAddNode " + form.getName());
        log.info("submit is " + submitFlag);
        DivInfo d = new DivInfo();
        d.id = "maintain";
        d.setName(form.getName());
        d.setType(form.getType());;

        return new ModelAndView(DESTINATION_TILE);
    }

    @RequestMapping(value = "createTree", method = RequestMethod.POST)
    public ModelAndView createTree(
            @ModelAttribute(TREE_DATA_KEY) String treeDataOld,
            @ModelAttribute(CREATE_TREE_BEAN_NAME) FormBean form,
            BindingResult result,
            WebRequest webRequest, HttpSession session, Model model) {
        log.info("createTree " + form.getName());
        log.info("treeDataOld "+treeDataOld);
        Object[] vargs = new Object[1];
        vargs[0] = "";
        String treeData = "";
        try {
            String name = "";
            name = form.getName();
            if (name == null) {
                name = "";
            }
            name = name.trim();
            if (StringUtils.isEmpty(name)) {
                result.reject("empty.name");
                treeData = treeDataOld;
            } else {
                treeData = jService.structureToString(
                        jService.createInitialDivision(name));
            }



        } catch (HospitalServiceException ex) {
            log.error("Hospital error " + ex.getMessage());
            vargs[0] = ex.getMessage();
            result.reject("duplicate.error", vargs, "Tree already exists");
            treeData = treeDataOld;



        } catch (IOException ioerr) {
            log.error("io error " + ioerr.getMessage());
            vargs[0] = ioerr.getMessage();
            result.rejectValue("name", "io.error", vargs,
                    "default io error");
            treeData = treeDataOld;
        }
        return new ModelAndView(DESTINATION_TILE, TREE_DATA_KEY, treeData);
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
