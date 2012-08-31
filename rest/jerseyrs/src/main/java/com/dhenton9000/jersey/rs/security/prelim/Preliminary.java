package com.dhenton9000.jersey.rs.security.prelim;

import com.dhenton9000.jersey.rs.MyResource;
import com.sun.jersey.spi.resource.Singleton;
import com.sun.jersey.api.spring.Autowire;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import com.sun.jersey.api.core.ResourceContext;

//both @Autowire and @Autowired are required for automatic wiring

@Singleton
@Autowire
//@Path("/prelim/applications/")
public class Preliminary {
    @Context
    protected UriInfo uriInfo;
    @Context
    protected ResourceContext resourceContext;
    
   // @Autowired
    //@Qualifier("jobBean")
    private WireClass wireClass = null;
    
    //@GET 
   // @Produces("text/html")
	public String snarf() 
	{
		String info = "<body><html><ul>";
                info += "<li> baseURI: "+uriInfo.getBaseUri()+"</li>";
                info += "<li> Path: "+uriInfo.getPath()+"</li>";        
                info += "<li> Abs Path: "+uriInfo.getAbsolutePath()+"</li>"; 
                info += "</ul><h2>Resource Context</h2><ul>";
                info += "<li> Sample Get Resource: "+resourceContext.getResource(MyResource.class).getIt() +"</li>";
                info += "<li> AutoWired: "+wireClass.getMessage() +"</li>";
               info += "</ul></html></body>";
                
                return info;
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
    
    
    
}
