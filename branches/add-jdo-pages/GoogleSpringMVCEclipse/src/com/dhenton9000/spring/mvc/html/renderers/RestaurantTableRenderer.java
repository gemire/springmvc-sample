package com.dhenton9000.spring.mvc.html.renderers;
import java.util.List;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
public class RestaurantTableRenderer {

	private String basePath = "";
	
	
	public String renderHtmlTable(List<Restaurant> restaurants)
	{
		StringBuilder html = new StringBuilder();
		html.append("<table class=\"fade in table table-condensed table-hover table-bordered\">\n");
		html.append("<tr><th>Name</th><th>City</th><th>State</th><th>Zip Code</th><th>Version</th><th>Action</th></tr>\n");
		for (Restaurant r:restaurants)
		{
			html.append("<tr><td>");
			html.append(r.getName());
			html.append("</td><td>");
			html.append(r.getCity());
			html.append("</td><td>");
			html.append(r.getState());
			html.append("</td><td>");
			html.append(r.getZipCode());
			html.append("</td><td>");
			html.append(r.getVersion());
			html.append("</td><td>");
			String ainfo = "<a href=\""+getBasePath()+r.getId().getId()+"\">Edit</a>";
			html.append(ainfo);
			
			

			html.append("</td></tr>\n");
		}
		
		
		html.append("</table>\n"); 
		return html.toString();
		
		
	}


	public String getBasePath() {
		return basePath;
	}


	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
}
