/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jersey.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 */
public class TestChain {
    private Integer id = null;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    
    @GET
    @Produces("text/html")
    public String getAlpha()
    {
         return "alpha mail "+getId();
    }
 
    @GET
    @Produces("text/html")
    @Path("test/{otherStuff}")
    public String getSomeMoreStuff(@PathParam("otherStuff") String otherStuff)
    {
        return "id is from resource "+getId()+" other stuff: "+otherStuff;
    }
    
}
