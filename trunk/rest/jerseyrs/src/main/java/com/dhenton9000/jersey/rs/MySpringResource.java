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

/**
 * In this case the root is :
 * http://localhost:9090/jerseyrs/resources/
 * then add 'spring/myresource' because of the path
 * 
 * http://localhost:9090/jerseyrs/resources/spring/myresource
 * 
 * @author dhenton
 */
@Path("/spring/myresource/")
public class MySpringResource {

    private WireClass wireClass = null;
    private ApplicationsDAO appDAO = null;
    @Context
    protected UriInfo uriInfo;
    @Context
    protected ResourceContext resourceContext;

    
    
    /**
     * To get here, use this, since this is serving at the root of the path
     * This also tests bean injected via xml for the WireClass sample, which
     * is created and primed in the spring-beans.xml file. That in turn is 
     * loaded by stuff in the web.xml
     * http://localhost:9090/jerseyrs/resources/spring/myresource
    */
    @GET
    @Produces("text/html")
    public String getIt() {
        return "<body><html><h1>Hi there from spring! "
                + getWireClass().getMessage() + " " + appDAO.toString() + "</h1></html></body>";
    }

    /**
     * http://localhost:9090/jerseyrs/resources/spring/myresource/xml/2
     * @param id
     * @return 
     */
    @GET
    @Path("xml/{id}/")
    @Produces("application/xml")
    public ApplicationsConverter getApp(@PathParam("id") Integer id) {
        return appDAO.findApplicationsWithGroupsAndUsers(id);
    }

    /**
     * nothing added here so as to delegate to the various methods in the
     * subresource class of TestChain
     * http://localhost:9090/jerseyrs/resources/spring/myresource/chain/55
     * @param id
     * @return 
     */
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
