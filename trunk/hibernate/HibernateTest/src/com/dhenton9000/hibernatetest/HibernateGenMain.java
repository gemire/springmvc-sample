package com.dhenton9000.hibernatetest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateGenMain {

	private static Logger log = LogManager.getLogger(HibernateGenMain.class);
	
	public static void main(String[] args) {
	
		
		log.debug("start");
		
	//	Configuration cfg = (new Configuration()).configure();
		Configuration cfg = (new Configuration()).configure("hibernate-sec.cfg.xml");
		SchemaExport schemaExport = new SchemaExport(cfg);
		
		schemaExport.create(true,true);
		
		
		log.debug("end");
		
	}
	
}
