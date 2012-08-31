package com.dhenton9000.spring.demos.demobeans;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Animal implements Creature {

	private String sound = null;
	private String name = null;
    private static Logger log = LogManager.getLogger(Animal.class);
	
	 
	
	public String getSound() {
		
		
		
		return sound;
	}



	public void setSound(String sound) {
		log.debug("in animal setting sound to "+sound);
		this.sound = sound;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String speak() {
		
		return "A "+name+" says '"+ sound+"'! ";
	}

}
