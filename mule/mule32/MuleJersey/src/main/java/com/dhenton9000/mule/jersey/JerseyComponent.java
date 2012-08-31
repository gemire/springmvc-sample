/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.jersey;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
/**
 *
 * @author dhenton
 */
@Path("/sayhello")
public class JerseyComponent {
     @GET
    @Produces("text/plain")
    @Path("/{name}")
    public String sayHelloWithUri(@PathParam("name") String name) {
        return "Hello " + name;
    }
}
