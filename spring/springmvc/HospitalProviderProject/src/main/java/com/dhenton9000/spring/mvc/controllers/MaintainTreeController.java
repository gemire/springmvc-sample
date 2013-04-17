/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.mvc.controllers;

import com.dhenton9000.neo4j.hospital.json.Division;
import com.dhenton9000.neo4j.hospital.json.HospitalServiceException;
import com.dhenton9000.neo4j.hospital.service.HospitalNeo4jDao;
import com.dhenton9000.neo4j.hospital.service.HospitalService;
import com.dhenton9000.spring.mvc.model.FormBean;
import com.dhenton9000.spring.mvc.model.MaintainTreeFormBean;
import com.dhenton9000.spring.mvc.model.SelectTreeBean;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dhenton
 */
@Controller
@RequestMapping("node/forms/*")
@SessionAttributes("maintainTreeFormBean")
public class MaintainTreeController {

    private static Logger log = LogManager.getLogger(MaintainTreeController.class);
    public static final String FORMBEAN_KEY = "maintainTreeFormBean";
    public static final String DESTINATION_TILE = "tiles.node.edit";
    @Autowired
    private HospitalService jService;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView showFormInInitialState() {

        MaintainTreeFormBean formBean = new MaintainTreeFormBean();
        formBean.setTreeSelectList(jService.getInitialTreeMap());
        return new ModelAndView(DESTINATION_TILE, FORMBEAN_KEY,
                formBean);

    }

    @RequestMapping(value = "insertNode", method = RequestMethod.POST)
    public ModelAndView insertNode(@ModelAttribute(FORMBEAN_KEY) 
            MaintainTreeFormBean maintainForm, BindingResult result) {

        String parentLabel = maintainForm.getInsertParentName();
        String newDivisionLabel = maintainForm.getInsertName();
        String treeRootName = maintainForm.getSelectedTree();

        Object[] vargs = new Object[1];
        vargs[0] = "";

        try {
            jService.attachDivisionbyLabels(parentLabel, newDivisionLabel);
            maintainForm.setTreeData(jService.structureToString(jService.buildDivisonFromDb(treeRootName)));
        } catch (HospitalServiceException ex) {
            log.error("Hospital error " + ex.getMessage());
            vargs[0] = ex.getMessage();
            result.reject("hospital.error", vargs, "Hospital Problem");


        } catch (IOException ioerr) {
            log.error("io error " + ioerr.getMessage());
            vargs[0] = ioerr.getMessage();
            result.rejectValue("name", "io.error", vargs,
                    "default io error");

        }


        return new ModelAndView(DESTINATION_TILE, FORMBEAN_KEY, maintainForm);
    }

    @RequestMapping(value = "createTree", method = RequestMethod.POST)
    public ModelAndView createTree(@ModelAttribute(FORMBEAN_KEY) 
            MaintainTreeFormBean maintainForm, BindingResult result) {

        Object[] vargs = new Object[1];
        vargs[0] = "";
        try {
            String name = "";
            name = maintainForm.getCreateTreeName();
            if (name == null) {
                name = "";
            }
            name = name.trim();
            if (StringUtils.isEmpty(name)) {
                result.reject("empty.name");
                log.error("empty name in createTree!");

            } else {
                Division newDiv = jService.createInitialDivision(name);
                Map<String, String> treeList = jService.getInitialTreeMap();
                maintainForm.setTreeSelectList(treeList);
                maintainForm.setTreeData(jService.structureToString(newDiv));
                maintainForm.setSelectedTree(name);
                maintainForm.setMaintainName(name);
                maintainForm.setMaintainId(newDiv.getId().toString());
                maintainForm.setMaintainType(HospitalNeo4jDao.NODE_TYPE.Division.toString());
            }

        } catch (HospitalServiceException ex) {
            log.error("Hospital error " + ex.getMessage());
            vargs[0] = ex.getMessage();
            result.reject("duplicate.error", vargs, "Tree already exists");
            log.error("duplicate name in createTree!");


        } catch (IOException ioerr) {
            log.error("io error " + ioerr.getMessage());
            vargs[0] = ioerr.getMessage();
            result.rejectValue("name", "io.error", vargs,
                    "default io error");

        }
        return new ModelAndView(DESTINATION_TILE, FORMBEAN_KEY, maintainForm);
    }

    @RequestMapping(value = "selectTree", method = RequestMethod.POST)
    public ModelAndView selectTree(@ModelAttribute(FORMBEAN_KEY) 
            MaintainTreeFormBean maintainForm, BindingResult result) {
        String name = maintainForm.getSelectedTree();
        try {
            Division newDiv = jService.buildDivisonFromDb(name);
            maintainForm.setMaintainName(name);
            maintainForm.setMaintainId(newDiv.getId().toString());
            maintainForm.setMaintainType(HospitalNeo4jDao.NODE_TYPE.Division.toString());
            String newTreeData = jService.structureToString(newDiv);
            maintainForm.setTreeData(newTreeData);
        } catch (Exception ioerr) {
            log.error("io error " + ioerr.getMessage());
        }

        return new ModelAndView(DESTINATION_TILE, FORMBEAN_KEY, maintainForm);
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
