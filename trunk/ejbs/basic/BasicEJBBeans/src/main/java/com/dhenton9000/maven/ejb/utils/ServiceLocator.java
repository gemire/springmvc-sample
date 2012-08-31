package com.dhenton9000.maven.ejb.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ServiceLocator {

	public ServiceLocator() {
	}

	private static final Logger log = LogManager
			.getLogger(ServiceLocator.class);

	public Object getEJB(String jndiName) throws NamingException {
		Object object = null;
		InitialContext ctx = new InitialContext();
		
		object = ctx.lookup(jndiName);
		return object;
	}

	public DataSource getDataSource(String jdbcName) throws NamingException {
		InitialContext ctx = new InitialContext();

		Context envCtx = (Context) ctx.lookup("java:comp/env");

		// Look up our data source
		DataSource ds = (DataSource) envCtx.lookup(jdbcName);

		return ds;

	}

}
