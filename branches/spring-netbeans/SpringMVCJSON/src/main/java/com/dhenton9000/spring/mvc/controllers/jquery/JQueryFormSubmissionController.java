package com.dhenton9000.spring.mvc.controllers.jquery;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dhenton9000.spring.mvc.model.Book;


/**
 * 
 * @author Don
 * 
 */

@Controller
@RequestMapping(value = "/jquery/formSubmission/*")
public class JQueryFormSubmissionController {
	private static final Logger log = LogManager
			.getLogger(JQueryFormSubmissionController.class);

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String goToFormSubmission() {

		return "tiles.jquery.formSubmission";

	}
	
 
	@RequestMapping(value="getBook",method=RequestMethod.GET) 
	public @ResponseBody List<Book> getBookByName(@RequestParam("officeCode") String officeCode) {
		return getBookForOffice(officeCode);
 
	}
 
	
	
	@RequestMapping(value="getBook") 
	public @ResponseBody List<Book> postBookByName(@RequestParam("officeCode") String officeCode) {
		return getBookForOffice(officeCode);
 
	}

	private List<Book> getBookForOffice(String officeName) {
		ArrayList<Book> bookList = new ArrayList<Book>();
		log.debug("got request "+officeName);
		Book b = new Book();
		b.setOfficeName(officeName);
		ArrayList<String> rev = new ArrayList<String>();
		rev.add("Manny");
		rev.add("Moe");
		rev.add("Jack");
		b.setNumPages(450);
		b.setReviewers(rev);
		b.setiSBN("778-21-344");

		bookList.add(b);
		b = new Book();
		b.setTitle("Get a Job 2: Just when you thought is was safe to be Unemployed");
		b.setiSBN("900-345-22");
		b.setNumPages(999);
		ArrayList<String> rev2 = new ArrayList<String>();
		rev2.add("Huey");
		rev2.add("Dewey");
		rev2.add("Louie");
		b.setOfficeName(officeName);
		b.setReviewers(rev2);
		bookList.add(b);
		return bookList;
	}

}
