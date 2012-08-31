package com.dhenton9000.classic.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import com.dhenton9000.classic.generic.dao.GenericHibernateDAO;

public class ClassicCarsDAO extends GenericHibernateDAO {
	private static ClassicCarsDAO instance = null;
	private static Logger log = LogManager.getLogger(ClassicCarsDAO.class);
	// ~--- constructors
	// ---------------------------------------------------------
	/**
	 * 
	 * The constructor initializes the factory
	 */
	public ClassicCarsDAO() {
		 
			super();
		 
	}

	public static synchronized ClassicCarsDAO getInstance() {
		if (instance == null) {
			instance = new ClassicCarsDAO();
		}

		return instance;
	}
	
	
	
	
}
