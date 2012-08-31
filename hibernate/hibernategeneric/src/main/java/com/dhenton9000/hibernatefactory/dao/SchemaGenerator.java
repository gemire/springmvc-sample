package com.dhenton9000.hibernatefactory.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

public class SchemaGenerator {

	private Logger logger = LogManager.getLogger(SchemaGenerator.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SchemaGenerator sG = new SchemaGenerator();
		sG.createSchema();

	}

	public void createSchema() {

		logger.info("begin database schema creation =========================");

		Configuration cfg = (new Configuration())
				.configure("hibernate.cfg.xml");
		SchemaExport schemaExport = new SchemaExport(cfg);

		schemaExport.create(true, true);

		logger.info("end database schema creation ===========================");
	}

}
