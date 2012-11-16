/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jersey.rs;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author dhenton
 */
@Path("post/resource/")
public class PostResource {

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("formdemo/")
    public void newTodo(@FormParam("id") String id,
            @FormParam("summary") String summary,
            @Context HttpServletResponse servletResponse) throws IOException {
 
        PrintWriter p = servletResponse.getWriter();
        p.println("<body><html>");
        p.println("<h3>Get a job</h3>");
        p.println("<p>You sent a summary of : <b>"+summary+"</b></p>");
        p.println("<p>You sent an id of : <b>"+id+"</b></p>");
        p.println("</html></body>");
        p.flush();
    }
}
