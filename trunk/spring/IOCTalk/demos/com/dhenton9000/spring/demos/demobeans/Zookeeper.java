package com.dhenton9000.spring.demos.demobeans;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class Zookeeper implements Creature {

	private String sound = null;
	private String name = null;
    private static Logger log = LogManager.getLogger(Zookeeper.class);

	public Zookeeper(String n, String s)
	{
		name = n;
		sound = s;
		log.debug("in zookeeper constructor name "+name+" sound "+sound);
	}
	
	public String speak() {
		 return "My name is "+name+" and I say "+sound;
	}

}
