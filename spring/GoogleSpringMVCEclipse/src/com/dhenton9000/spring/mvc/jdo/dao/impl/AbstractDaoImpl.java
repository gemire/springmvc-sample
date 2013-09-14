package com.dhenton9000.spring.mvc.jdo.dao.impl;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public abstract class AbstractDaoImpl {

	private PersistenceManagerFactory pmfInstance = JDOHelper.
			getPersistenceManagerFactory("transactions-optional");

	public void setPmfInstance(PersistenceManagerFactory pmfInstance) {
		this.pmfInstance = pmfInstance;
	}

	public PersistenceManagerFactory getPmfInstance() {
		return pmfInstance;
	}

	
}
