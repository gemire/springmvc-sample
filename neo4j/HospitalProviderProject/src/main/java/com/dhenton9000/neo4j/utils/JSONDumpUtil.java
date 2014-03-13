/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.utils;

import com.dhenton9000.neo4j.hospital.json.Division;
import com.dhenton9000.neo4j.hospital.json.HospitalServiceException;
import com.dhenton9000.neo4j.hospital.service.HospitalService;
import com.dhenton9000.spring.mvc.controllers.MaintainTreeController;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author dhenton
 */
public class JSONDumpUtil {

    private static ClassPathXmlApplicationContext context = null;
    private HospitalService jService;
    private static Logger log = LogManager.getLogger(JSONDumpUtil.class);

    public void doCreation(ClassPathXmlApplicationContext context) {
        log.debug("begin");
        Division newDiv = null;
        String newTreeData = null;
        jService = context.getBean(HospitalService.class);
        EmbeddedGraphDatabase g = context.getBean(EmbeddedGraphDatabase.class);
        try {
            newDiv = jService.buildDivisonFromDb("Blue Cross");
            newTreeData = jService.structureToString(newDiv);
            File fileDest = new File("target/listing/hospital.json");
            FileUtils.writeStringToFile(fileDest, newTreeData, "UTF-8");
        } catch (HospitalServiceException ex) {
            log.error("hospital exception " + ex.getMessage());

        } catch (IOException ex) {
            log.error("io problem " + ex.getMessage());
        } finally {
            g.shutdown();
        }

    }

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("json-dump-spring.xml");

        (new JSONDumpUtil()).doCreation(context);
    }
}
