/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jersey.rs;

import com.dhenton9000.hibernatesecurity.Users;
import com.dhenton9000.hibernatesecurity.converters.UsersConverter;
import com.dhenton9000.hibernatesecurity.dao.UsersDAO;
import com.sun.jersey.api.core.ResourceContext;
import javax.ws.rs.*;
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
    public Response putUser(UsersConverter u) {
        Response res;
        if (userDAO.findById(u.getUserId()) != null) {
            res = Response.notModified().build();
        } else {
            Users uNew = new Users();
            uNew.setUserId(u.getUserId());
            uNew.setUsername(u.getUsername());
            userDAO.save(uNew);
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        return res;

    }

    /**
     * http://localhost:9090/jerseyrs/resources/spring/users/put/fred/ted/
     *
     * @param username
     * @param userId
     * @return
     */
    @PUT
    @Path("put/{username}/{userid}/")
    public Response putUser(@PathParam("username") String username, @PathParam("userid") String userId) {
        Response res;
        if (userDAO.findById(userId) != null) {
            res = Response.notModified().build();
        } else {
            Users u = new Users();
            u.setUserId(userId);
            u.setUsername(username);
            userDAO.save(u);
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        return res;
    }

    @DELETE
    @Path("delete/{userid}/")
    public Response deleteUser(@PathParam("userid") String userId) {
        Response res;
        Users u = userDAO.findById(userId);

        if (u == null) {
            logger.debug("hit found in delete for " + userId);
            res = Response.notModified().build();
        } else {
            logger.debug("hit delete for " + userId);
            userDAO.delete(u);

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
