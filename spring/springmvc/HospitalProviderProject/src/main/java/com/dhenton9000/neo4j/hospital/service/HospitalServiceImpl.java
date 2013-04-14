/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.hospital.service;

import com.dhenton9000.neo4j.hospital.json.Division;
import com.dhenton9000.neo4j.hospital.json.HospitalNode;
import com.dhenton9000.neo4j.hospital.json.HospitalServiceException;
import com.dhenton9000.neo4j.hospital.json.Provider;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.neo4j.graphdb.Node;

/**
 * Service class for processing JSON for the Provider structures
 *
 * @author dhenton
 */
public class HospitalServiceImpl implements HospitalService  {

    
    private ObjectMapper mapper = new ObjectMapper();
    private final Logger log = LogManager.getLogger(HospitalServiceImpl.class);
    private HospitalNeo4jDao hospitalDao = null;

  
   
   

    @Override
    public String structureToString(Division root) throws IOException {
        String temp = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        return temp;
    }

    @Override
    public String divArrayToString(List<HospitalNode> root) throws IOException {
        String temp = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        return temp;
    }

    @Override
    public Division stringToStructure(String jsonString) throws IOException {
        return mapper.readValue(jsonString, Division.class);
    }

   

   
    /**
     * @return the hospitalDao
     */
    public HospitalNeo4jDao getHospitalDao() {
        return hospitalDao;
    }

    /**
     * @param hospitalDao the hospitalDao to set
     */
    public void setHospitalDao(HospitalNeo4jDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    public Division attachFullTree(Division d) 
            throws HospitalServiceException {
        return getHospitalDao().attachFullTree(d);
    }

    public Division buildDivisonFromDb(String startDivisionLabel) {
         return getHospitalDao().buildDivisionFromDb(startDivisionLabel);
    }

    public Provider attachProvider(Division parent, Provider p) 
            throws HospitalServiceException {
        
         return getHospitalDao().attachProvider(parent,p);
    }

    public Division createInitialDivision(String divisionLabel) throws HospitalServiceException {
        
        Division d = new Division();
        Node n = getHospitalDao().createInitialNode(divisionLabel);
        d.setId(new Long(n.getId()));
        d.setName(divisionLabel);
        d.setisOpen(true);
        return d;
    }

    public Map<String, String> getInitialTreeMap() {
        Map<String,String> n = new HashMap<String,String>();
        Map<String, String> m = getHospitalDao().getInitialNodes();
        Set<String> kSet = m.keySet();
        Iterator<String> iter = kSet.iterator();
        while (iter.hasNext())
        {
            String k = m.get(iter.next());
            n.put(k,k);
        }
        return n;
    }

    public void attachDivisionbyLabels(String parentLabel, 
        String newDivisionLabel)  throws HospitalServiceException {
        getHospitalDao().attachDivisionbyLabels(parentLabel,newDivisionLabel) ;      
    }

  



    
}
