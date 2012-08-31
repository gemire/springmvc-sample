package com.dhenton9000.jersey.rs;

import com.dhenton9000.hibernatesecurity.converters.ApplicationsConverter;
import com.dhenton9000.jersey.rs.security.prelim.WireClass;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.dhenton9000.hibernatesecurity.dao.ApplicationsDAO;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import com.sun.jersey.api.core.ResourceContext;

@Path("/spring/myresource/")
public class MySpringResource {

    private WireClass wireClass = null;
    private ApplicationsDAO appDAO = null;
    @Context
    protected UriInfo uriInfo;
    @Context
    protected ResourceContext resourceContext;

    @GET
    @Produces("text/html")
    public String getIt() {
        return "<body><html><h1>Hi there from spring! "
                + getWireClass().getMessage() + " " + appDAO.toString() + "</h1></html></body>";
    }

    @GET
    @Path("xml/{id}/")
    @Produces("application/xml")
    public ApplicationsConverter getApp(@PathParam("id") Integer id) {
        return appDAO.findApplicationsWithGroupsAndUsers(id);
    }

    // nothing added here so as to delegate to the various methods in the
    // subresource class of TestChain
    @Path("chain/{id}/")
    public TestChain getChain(@PathParam("id") Integer id) {

        TestChain t = resourceContext.getResource(TestChain.class);
        t.setId(id);
        return t;
    }

    /**
     * @return the wireClass
     */
    public WireClass getWireClass() {
        return wireClass;
    }

    /**
     * @param wireClass the wireClass to set
     */
    public void setWireClass(WireClass wireClass) {
        this.wireClass = wireClass;
    }

    /**
     * @return the appDAO
     */
    public ApplicationsDAO getAppDAO() {
        return appDAO;
    }

    /**
     * @param appDAO the appDAO to set
     */
    public void setAppDAO(ApplicationsDAO appDAO) {
        this.appDAO = appDAO;
    }
}
