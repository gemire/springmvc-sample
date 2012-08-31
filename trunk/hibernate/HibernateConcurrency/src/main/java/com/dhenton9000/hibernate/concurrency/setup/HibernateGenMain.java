package com.dhenton9000.hibernate.concurrency.setup;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateGenMain {

	private static Logger log = LogManager.getLogger(HibernateGenMain.class);
	/**
	 * programmatically create a schema from a cfg file see ANT build file instead.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		log.debug("start database schema");
		
		// this will create the database schema and WILL OVERWRITE THE TABLES
		Configuration cfg = (new Configuration()).configure("hibernate.cfg.xml");
		SchemaExport schemaExport = new SchemaExport(cfg);
		schemaExport.create(true,true);
	
		log.debug("end database schema ");
		
		
		
		
	}
	
}
