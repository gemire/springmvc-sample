package com.dhenton9000.spring.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dhenton9000.spring.rest.store.categories.BaseCategory;
import com.dhenton9000.spring.rest.store.categories.CategoryDataProvider;
import com.dhenton9000.spring.rest.store.categories.CategoryDataProviderImpl;

@Controller
@RequestMapping(value = "rest/categories/*")
public class StoreCategoryRestController {
	private static Logger log = LogManager
			.getLogger(StoreCategoryRestController.class);

	private CategoryDataProvider provider = new CategoryDataProviderImpl();

	/**
	 * *getLevelData?level=1&groupId=3
	 * http://localhost:8888/app/rest/categories/getLevelData?level=1&groupId=3
	 * 
	 *  The signature with no id is to get the level 1 initial data
	 *  if level is specified, the id is of the level above 
	 *  eg if level is 2, then id refers to a level 1 item
	 */
	@RequestMapping(value = "getLevelData", method = RequestMethod.GET)
	public @ResponseBody
	List<BaseCategory> getLevelData(@RequestParam("level") Integer level,
			@RequestParam("groupId") Integer groupId,
			@RequestParam(value="id",defaultValue="0") Integer id) {
		 
		// log.debug("@@@@@@");
		List<BaseCategory> results = null;
		if (id == null)
			id = 0;
		 
		
		switch (level) {
		case 1:
			results = provider.getLevel1Data();
			 
			break;
		case 2:
			results = provider.getLevel2Data(id);
			 
			break;
		case 3:
			results = provider.getLevel3Data(id);
			  
			break;
		default:
			 
		}

		return results;
	}

}
