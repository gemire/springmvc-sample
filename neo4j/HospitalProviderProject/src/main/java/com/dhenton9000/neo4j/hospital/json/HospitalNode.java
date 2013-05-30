/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.hospital.json;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;

/**
 *
 * @author dhenton
 */

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=As.PROPERTY, property="type")
  @JsonSubTypes({

        @JsonSubTypes.Type(name="Division",value=Division.class),
        @JsonSubTypes.Type(name="Provider",value=Provider.class)

    }) 
public interface HospitalNode {

    String getName();
    void setName(String t);
    List<HospitalNode> getChildren();
    void setChildren(List<HospitalNode> children);
    Long getId();
    void setId(Long id);
    //public String getNodeType();
    //public void setNodeType(String t);
   @JsonProperty(value="is_open")
   void setisOpen(boolean t);
   @JsonProperty(value="is_open")
   boolean isOpen(); 
}
