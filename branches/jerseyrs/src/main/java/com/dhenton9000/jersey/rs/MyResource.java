package com.dhenton9000.jersey.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
@Path("myresource")
public class MyResource{
/** Method processing HTTP GET requests, producing "text/plain" MIME media
* type.
* @return String that will be send back as a response of type "text/plain".
* 
* http://localhost:9090/jerseyrs/resources/myresource to see this in 
* action
* the jerseyrs comes from the project name;
* resources is from the web.xml url-pattern
* in this case the jetty instance loaded in the pom file
* and the myresource is in the Path tag above
* 
* The auto generated wadl is at
* http://localhost:9090/jerseyrs/resources/application.wadl
*/
@GET @Produces("text/html")
	public String getIt() 
	{
		return "<body><html><h1>Hi there!</h1></html></body>";
	}
}