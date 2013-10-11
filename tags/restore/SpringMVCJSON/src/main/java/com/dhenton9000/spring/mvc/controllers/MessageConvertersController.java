package com.dhenton9000.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dhenton9000.spring.mvc.model.JavaBean;
import com.sun.syndication.feed.atom.Feed;
import com.sun.syndication.feed.rss.Channel;
import org.springframework.ui.Model;

@Controller
@RequestMapping("messageconverters/*")
public class MessageConvertersController {

	 public static final String DESTINATION_TILE = "tiles.processing.input";
	 public static final String RESULTS_KEY = "results";

	 /**
	  * The home page for this group
	  * @return
	  */
		@RequestMapping(value="home", method=RequestMethod.GET)
		public String goHome() {
			
			 return DESTINATION_TILE;
		}
	 
	 
	 /**
	  * converts the contents of a post to a string
	  * @param string
	  * @return
	  */
	@RequestMapping(value="stringPOST", method=RequestMethod.POST)
	public ModelAndView readString(@RequestBody String string) {
		 String t = "Read string '" + string + "'";
		 ModelAndView model = new ModelAndView(DESTINATION_TILE);
		 model.addObject(RESULTS_KEY,t);
		 return model;
	}
	
 
	// FormHttpMessageConverter (note: not recommended for reading browser form posts.  Use standard JavaBean form binding instead. see 'form' showcase/package).
	
	@RequestMapping(value="form", method=RequestMethod.POST)
	public @ResponseBody String readForm(@RequestBody MultiValueMap<String, String> form) {
		return "Read form map " + form;
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public @ResponseBody MultiValueMap<String, String> writeForm() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("foo", "bar");
		map.add("fruit", "apple");
		return map;
	}

	// Jaxb2RootElementHttpMessageConverter (requires JAXB2 on the classpath - useful for serving clients that expect to work with XML)
	
	@RequestMapping(value="/xml", method=RequestMethod.POST)
	public @ResponseBody String readXml(@RequestBody JavaBean bean) {
		
		
		
		return "Read from XML " + bean;
	}
	
	@RequestMapping(value="/xml", method=RequestMethod.GET)
	public @ResponseBody JavaBean writeXml() {
		 JavaBean jb = new JavaBean();
		 jb.setFoo("FOO");
		 jb.setFruit("tomato");
		 return jb;
	}
	
	
	@RequestMapping(value="/xmlname/{name}", method = RequestMethod.GET)
	public @ResponseBody JavaBean getCoffeeInXML(@PathVariable String name) {

		JavaBean coffee = new JavaBean();
		
		return coffee;

	}
	

	// MappingJacksonHttpMessageConverter (requires Jackson on the classpath - particularly useful for serving JavaScript clients that expect to work with JSON)
	
	@RequestMapping(value="/json", method=RequestMethod.POST)
	public @ResponseBody String readJson(@RequestBody JavaBean bean) {
		return "Read from JSON " + bean;
	}
	
	@RequestMapping(value="/json", method=RequestMethod.GET)
	public @ResponseBody JavaBean writeJson() {
		return new JavaBean();
	}

	// AtomFeedHttpMessageConverter (requires Rome on the classpath - useful for serving Atom feeds)
	
	@RequestMapping(value="/atom", method=RequestMethod.POST)
	public @ResponseBody String readFeed(@RequestBody Feed feed) {
		return "Read " + feed.getTitle();
	}
	
	@RequestMapping(value="/atom", method=RequestMethod.GET)
	public @ResponseBody Feed writeFeed() {
		Feed feed = new Feed();
		feed.setFeedType("atom_1.0");
		feed.setTitle("My Atom feed");
		return feed;
	}

	// RssChannelHttpMessageConverter (requires Rome on the classpath - useful for serving RSS feeds)
	
	@RequestMapping(value="/rss", method=RequestMethod.POST)
	public @ResponseBody String readChannel(@RequestBody Channel channel) {
		return "Read " + channel.getTitle();
	}
	
	@RequestMapping(value="/rss", method=RequestMethod.GET)
	public @ResponseBody Channel writeChannel() {
		Channel channel = new Channel();
		channel.setFeedType("rss_2.0");
		channel.setTitle("My RSS feed");
		channel.setDescription("Description");
		channel.setLink("http://localhost:8080/mvc-showcase/rss");
		return channel;
	}

}