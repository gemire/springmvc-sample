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
import org.springframework.web.servlet.ModelAndView;

/**
 * This code will not compile on the Google app engine, but could be
 * used to generate images on the fly, such as CAPTCHA
 * @author Don
 *
 */



@Controller
@RequestMapping(value = "/jquery/demos/*")
public class MainJQueryController {

	
	public static final String IMAGE_KEY = "image";
	
	private static Logger log = LogManager
			.getLogger(MainJQueryController.class);

	@RequestMapping(value = "linkedLists", method = RequestMethod.GET)
	public String goToLinkedLists() {

		return "tiles.jquery.linkedlists";

	}

	@RequestMapping(value = "arttimer", method = RequestMethod.GET)
	public String goToArtTimer() {

		return "tiles.jquery.arttimer";

	}
	
	
	@RequestMapping(value = "jsonData", method = RequestMethod.GET)
	public String goToJSONData() {

		return "tiles.jquery.jsonData";

	}
	
	@RequestMapping(value = "findingElements", method = RequestMethod.GET)
	public String goToFindingElements() {

		return "tiles.jquery.findingElements";

	}
	
	
	
	@RequestMapping(value = "positioning", method = RequestMethod.GET)
	public String goToPositioning() {

		return "tiles.jquery.positioning";

	}

	@RequestMapping(value = "pixDisplay", method = RequestMethod.GET)
	public String goToPixDisplay() {

		return "tiles.jquery.pixDisplay";

	}	
	
	@RequestMapping(value = "periodicUpdater", method = RequestMethod.GET)
	public String goToPeriodicUpdater() {

		return "tiles.jquery.periodicUpdater";

	}
	
	@RequestMapping(value = "doUpdate", method = RequestMethod.GET)
	public ResponseEntity<String> doUpdate() {
		HttpHeaders headers = new HttpHeaders();
		int i = getRandom();
		headers.setContentType(MediaType.TEXT_HTML);
		return new ResponseEntity<String>(""+i,
				headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "formSamples", method = RequestMethod.GET)
	public String goToFormSamples() {

		return "tiles.jquery.formSamples";

	}
	
	private int getRandom()
	{
		
		double z = 155* Math.random();
		return new Double(z).intValue();
	
	}
}
