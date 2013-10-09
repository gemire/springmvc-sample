package com.dhenton9000.spring.mvc.jdo.dao.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;


public class JacksonSampler {

	private static Logger log = LogManager.getLogger(JacksonSampler.class);
	public void doRead()
	{
		LocalServiceTestHelper helper = new LocalServiceTestHelper(
				new LocalDatastoreServiceTestConfig());
		helper.setUp();
		ObjectMapper mapper = new ObjectMapper();
		Restaurant r = new Restaurant();
		Key key = KeyFactory.createKey("Restaurant", 100101L);
		r.setId(key);
		r.setZipCode("909090");
		r.setName("Test");
		r.setVersion(1);
		r.setState("CA");
		r.setCity("Freson");
		Writer w = new StringWriter();
		try {
			mapper.writeValue(w, r);
		} catch ( Exception e) {
			log.error(e.getClass().getName()+" "+e.getMessage());
			
		}  
		helper.tearDown();
		log.info("\n\n"+w.toString());
	}
	
	
	
	public static void main(String[] args) {
		
		JacksonSampler j = new JacksonSampler();
		j.doRead();

	}

}
