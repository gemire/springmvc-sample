package com.dhenton9000.spring.mvc.controllers.jquery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dhenton9000.json.SampleGenerator;


/**
 * This code will not compile on the Google app engine, but could be
 * used to generate images on the fly, such as CAPTCHA
 * @author Don
 *
 */



@Controller
@RequestMapping(value = "/jquery/linkedlists/*")
public class LinkedListsRequestController {
	private long delay = 1500L;
	private static final Logger log = LogManager.getLogger(LinkedListsRequestController.class);

	
	
	@RequestMapping(value = "getCategories", method = RequestMethod.GET)
	public ResponseEntity<String> getCategories() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String categories = SampleGenerator.getJSONData(SampleGenerator.getCategories());
		return new ResponseEntity<String>(categories,
				headers, HttpStatus.OK);
	}

	@RequestMapping(value = "getSubCategories", method = RequestMethod.GET)
	public ResponseEntity<String> getSubCategories(@RequestParam("subCategory") int subCategory, @RequestParam("delay") boolean delay) {
		HttpHeaders headers = new HttpHeaders();
		if (delay)
			delay();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String results = SampleGenerator.getJSONData(SampleGenerator.getSubCategory(SampleGenerator.getCategories()[subCategory]));
		return new ResponseEntity<String>(results,
				headers, HttpStatus.OK);
	}
	
	private void delay() {
		
		long startVar = System.currentTimeMillis();
		long diff = 0L;
		while (true)
		{
			long nowVar = System.currentTimeMillis();
			diff = nowVar- startVar;
			if (diff > delay)
			{
				break;
			}
		}
		
		
	}

}