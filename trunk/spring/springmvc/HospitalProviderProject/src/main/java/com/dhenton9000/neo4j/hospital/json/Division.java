/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.hospital.json;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.annotate.JsonTypeName;

/**
 *
 * @author dhenton
 */
@JsonTypeName("Division")
public class Division implements HospitalNode {
    
    
    private String name;
   // private String type;
    private Long id;
    private List<HospitalNode> children =  new ArrayList<HospitalNode>();

    /**
     * @return the label
     */
    
    

    /**
     * @return the id
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    
    /**
     * @return the children
     */
    @Override
    public List<HospitalNode> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    
    @Override
    public void setChildren(List<HospitalNode> children) {
        this.children = children;
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
