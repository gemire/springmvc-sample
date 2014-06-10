package com.dhenton9000.json;

import java.io.StringWriter;
import java.io.Writer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
//import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

public class JacksonDemo {

	private static Logger log = LogManager.getLogger(JacksonDemo.class);
	public void demonstrateShowingNulls()
	{
		ObjectMapper mapper = new ObjectMapper();
		Restaurant res = new Restaurant();
		res.setVersion(1);
		res.setZipCode("zip");
		 
		Writer w = new StringWriter();
		try {
			mapper.writeValue(w, res);
		} catch ( Exception e) {
			log.error(e.getClass().getName()+" "+e.getMessage());
			
		}  
		//helper.tearDown();
		log.info("\n\n"+w.toString());
	}
	
	public void demonstrateNotShowingNulls()
	{
		ObjectMapper mapper = new ObjectMapper();
		Feature xx;
		mapper.configure(Feature.WRITE_NULL_PROPERTIES, false);
		
		//this is for newer versions
		//mapper.setSerializationInclusion(Inclusion.NON_NULL);
		//see the deprecation notes for WRITE_NULL_PROPERTIES above
		
		Restaurant res = new Restaurant();
		res.setVersion(1);
		res.setZipCode("zip");
		 
		Writer w = new StringWriter();
		try {
			mapper.writeValue(w, res);
		} catch ( Exception e) {
			log.error(e.getClass().getName()+" "+e.getMessage());
			
		}  
		//helper.tearDown();
		log.info("\n\n"+w.toString());
	}
	 
	
	public static void main(String[] args) {
		
		JacksonDemo j = new JacksonDemo();
		j.demonstrateShowingNulls();
		j.demonstrateNotShowingNulls();

	}

}
