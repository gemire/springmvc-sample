package com.dhenton9000.spring.mvc.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.*;

import com.dhenton9000.spring.mvc.model.Book;
import com.dhenton9000.spring.mvc.model.BookMaker;
import com.mkyong.common.model.Coffee;

@Controller
public class JsonTestController {
	
	
	//this will wire up with a bean in an spring bean xml file
	//thus you can use annotations to mark the controllers, but regular
	//xml to configure injected items Autowired will work on interfaces
	
	
	
	@Autowired 
	private BookMaker bookmaker = null;
	private static Logger log = LogManager.getLogger(JsonTestController.class);
	
	

	
	@RequestMapping("/jsondemo")
	public ModelAndView gotoJasonDemo() {
		 log.debug("hit json");
		return new ModelAndView("tiles.jsondemo.entry");
	}
	
	
	@RequestMapping(value="/json/name/getbook", method=RequestMethod.GET)
	public @ResponseBody Book getBookByName(@RequestParam String name) {
	   log.debug("name is "+name);
		
		return bookmaker.getBook();
	}
	
	
	@RequestMapping(value="/json/getbook", method=RequestMethod.GET)
	public @ResponseBody Book getBook() {
	   Book book = bookmaker.getBook();
	   book.setAuthor("fred");
		log.debug("hit default book");
		return book;
	}
	
	
	@RequestMapping(value="/json/coffee", method = RequestMethod.GET)
	public @ResponseBody Coffee getCoffeeBean(@RequestParam("brand") String brand) {

	
		Coffee coffee = new Coffee(brand+" deluxe server edition!!", 100);
	
		log.debug("hit coffee with name of '"+brand+"'");
		return coffee;

	}
	
	@RequestMapping(value="/json/sendCoffee", method = RequestMethod.POST)
	public @ResponseBody Coffee recieveCoffeeBean(@RequestBody Coffee coffee, HttpServletResponse response) {

		coffee.setQuantity(1010);
		log.debug("hit send coffee with brand of '"+coffee.getBrand()+"'");
		return coffee;

	}
	
	
 
	

	public void setBookmaker(BookMaker bookmaker) {
		this.bookmaker = bookmaker;
	}

	public BookMaker getBookmaker() {
		return bookmaker;
	}
	
}
