package com.dhenton9000.spring.mvc.model;

import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
 

public class Tester {

 	
		private Logger log = LogManager.getLogger(Tester.class);
		private Book book = new Book();
		 
		private ObjectMapper mapper = new ObjectMapper();
		
		@Before
		public void init() {
		 
		}
		
		@Test
		public void canSerializeBook() {
			 
			Assert.assertTrue("Cannot serialize Book class", mapper.canSerialize(Book.class));
		}
		
		@Test
		public void BookToJson() throws JsonGenerationException, JsonMappingException, IOException {
			String temp = mapper.writeValueAsString(book);
			
			if(log.isInfoEnabled())
				log.info(temp);
			
			Assert.assertNotNull("Writing Book as JSON string resulted in null.", temp);
		}
 
	}