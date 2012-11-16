/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jersey.rs;

import com.dhenton9000.hibernatesecurity.converters.UsersConverter;
import com.dhenton9000.hibernatesecurity.dao.UsersDAO;
import com.sun.jersey.api.core.ResourceContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


/**
 *
 * @author dhenton
 */
@Path("json/")
public class JsonResource {
    
    private Logger logger = LogManager.getLogger(JsonResource.class);
    private UsersDAO userDAO = null;
    @Context
    protected UriInfo uriInfo;
    @Context
    protected ResourceContext resourceContext;
    
    
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("simple/echo/")
    public UsersConverter jsonDemo(UsersConverter u) throws IOException {
        logger.debug("hit json Demo "+resourceContext+" -- "+userDAO);
        return u;
      
    }
    
    @GET
    @Path("simple/")
    @Produces(MediaType.APPLICATION_JSON)
    public UsersConverter jsonSimple() throws IOException {
        logger.debug("hit json Demo "+resourceContext+" -- "+userDAO);
        UsersConverter u = new UsersConverter("ted","fred");
        return u;
      
    }
    
    
    
      /**
     * @return the userDAO
     */
    public UsersDAO getUserDAO() {
        return userDAO;
    }

    /**
     * @param userDAO the userDAO to set
     */
    public void setUserDAO(UsersDAO userDAO) {
        this.userDAO = userDAO;
    }
}
