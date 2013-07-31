package com.dhenton9000.json;

import java.util.HashMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SampleGenerator {

	private static final String[] categories = { "Electronics", "Kitchen", "Bath",
			"Outdoors" ,"School Supplies"};
	private static HashMap<String, String[]> dataCategories = new HashMap<String, String[]>();
	private static Logger log = LogManager.getLogger(SampleGenerator.class);
	
	static 
	{
		
		String[] s0 = {"Games","Music","Ipods","Stereos","R/C Devices","Nuclear Weapons"};
		dataCategories.put(categories[0],s0);
		
		String[] s1 = {"Applicances","Dishes","Cookware","Pots and Pans"};
		dataCategories.put(categories[1],s1);
		
		String[] s2 = {"Towels","Sinks","Rubber Ducks"};
		dataCategories.put(categories[2],s2);

		String[] s3 = {"Weapons","Gas and Grilling","Swimming Pools"};
		dataCategories.put(categories[3],s3);
		
		String[] s4 = {"Pencils","Notebooks","Papers","Clothes"};
		dataCategories.put(categories[4],s4);
		
		//log.debug(getDataCategories());
		
		
	}
	
	
	
	
	/**
	 * @return the categories
	 */
	public static String[] getCategories() {
		return categories;
	}

	 

	private final static String itemTemplate = "{\"value\": \"#\",\"text\": \"$\"}";

	public static String getJSONData(String[] itemArray) {
		String cat = "[";
		for (int i = 0; i < itemArray.length; i++) {
			String t = itemTemplate.replaceAll("\\$", itemArray[i]) + ",\n";
			t = t.replaceAll("\\#", "" + i);
			cat += t;
		}
		cat = cat.trim();
		cat = cat.substring(0, cat.length() - 1);
		return cat + "]";
	}

	public static void main(String[] args) {
		//SampleGenerator sG = new SampleGenerator();
		//log.debug("\n"+SampleGenerator.getJSONData(SampleGenerator.getCategories()));
		//log.debug("\n"+SampleGenerator.getJSONData(SampleGenerator.getSubCategory(SampleGenerator.getCategories()[1])));

		String[] z = SampleGenerator.getSubCategory("Kitchen");
		
		
		
	}

	public static String[] getSubCategory(String category) {
			
		String[] cats = getDataCategories().get(category.trim());
		if (cats == null)
		{
			throw new RuntimeException("cannot find subcategory for '"+category+"'");
		}
		return cats;
	}


	 

	public static HashMap<String, String[]> getDataCategories() {
		return dataCategories;
	}

}
