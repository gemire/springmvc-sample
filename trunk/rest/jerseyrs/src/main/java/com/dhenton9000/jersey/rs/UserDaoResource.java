/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jersey.rs;

import com.dhenton9000.hibernatesecurity.Users;
import com.dhenton9000.hibernatesecurity.dao.UsersDAO;
import com.sun.jersey.api.core.ResourceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author dhenton
 */
@Path("/spring/users/")
public class UserDaoResource {

    private UsersDAO userDAO = null;
    @Context
    protected UriInfo uriInfo;
    @Context
    protected ResourceContext resourceContext;
    private Logger logger = LogManager.getLogger(UserDaoResource.class);

    @PUT
    @Path("putitem/")
    @Consumes(MediaType.APPLICATION_XML)
    public Response putUser(Users u) {
        Response res;
        if (userDAO.findById(u.getUserId()) != null) {
            res = Response.noContent().build();
        } else {
            userDAO.save(u);
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        return res;

    }

    
    
    /**
     * http://localhost:9090/jerseyrs/resources/spring/users/put/fred/ted/
     * @param username
     * @param userId
     * @return 
     */
    @PUT
    @Path("put/{username}/{userid}/")
    public Response putUser(@PathParam("username") String username, @PathParam("userid") String userId) {
        Response res;
        if (userDAO.findById(userId) != null) {
            res = Response.noContent().build();
        } else {
            Users u = new Users();
            u.setUserId(userId);
            u.setUsername(username);
            userDAO.save(u);
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        return res;
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
