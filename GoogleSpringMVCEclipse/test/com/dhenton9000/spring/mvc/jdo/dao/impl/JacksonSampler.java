package com.dhenton9000.spring.mvc.jdo.dao.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.dhenton9000.spring.mvc.jdo.entities.Restaurant;
import com.dhenton9000.spring.mvc.jdo.entities.RestaurantDTO;
import com.dhenton9000.spring.mvc.jdo.entities.ReviewDTO;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;


public class JacksonSampler {

	private static Logger log = LogManager.getLogger(JacksonSampler.class);
	public void doRead()
	{
		//LocalServiceTestHelper helper = new LocalServiceTestHelper(
		//		new LocalDatastoreServiceTestConfig());
		//helper.setUp();
		ObjectMapper mapper = new ObjectMapper();
//		RestaurantDTO r = new RestaurantDTO();
//	//	Key key = KeyFactory.createKey("Restaurant", 100101L);
//		r.setId(100101L);
//		r.setZipCode("909090");
//		r.setName("Test");
//		r.setVersion(1);
//		r.setState("CA");
//		r.setCity("Freson");
//		r.addReviewDTO(4, "bite me");

		ReviewDTO r = new ReviewDTO();
		Writer w = new StringWriter();
		try {
			mapper.writeValue(w, r);
		} catch ( Exception e) {
			log.error(e.getClass().getName()+" "+e.getMessage());
			
		}  
		//helper.tearDown();
		log.info("\n\n"+w.toString());
	}
	
	
	//{"name":null,"id":null,"state":null,"zipCode":"zip","city":null,"idAsLong":null,"reviews":[],"version":1}
	public void doRestaurantTest()
	{
		ObjectMapper mapper = new ObjectMapper();
		Restaurant res = new Restaurant();
		//res.setCity("city");
		//res.setName("name");
		//res.setState("state");
		res.setVersion(1);
		res.setZipCode("zip");
		RestaurantDTO rDTO = new RestaurantDTO(res);
		rDTO.setName("fred");
		Writer w = new StringWriter();
		try {
			mapper.writeValue(w, rDTO);
		} catch ( Exception e) {
			log.error(e.getClass().getName()+" "+e.getMessage());
			
		}  
		//helper.tearDown();
		log.info("\n\n"+w.toString());
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Restaurant>> violations = validator.validate(res);
		if (violations.size() != 0) {
			for (ConstraintViolation<Restaurant> vv: violations)
			{
				log.error(vv.getMessage());
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		JacksonSampler j = new JacksonSampler();
		j.doRestaurantTest();

	}

}
