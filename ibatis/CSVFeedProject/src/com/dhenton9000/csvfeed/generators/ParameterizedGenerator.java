/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.csvfeed.generators;

import com.dhenton9000.feeds.IFeedItemGenerator;
import com.dhenton9000.feeds.ItemGeneratorException;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * This is a generalized generator that takes an injected queryName A generator
 * produces a list of VO objects to be used for the feed. It can be thought of
 * as pouring meat into the meat grinder. This passes the query and expects a
 * parameter object. The ibatis query and the parameter class are synched in the
 * IBATIS file
 * 
 * @author Don
 */
public class ParameterizedGenerator extends SqlMapClientDaoSupport implements
		IFeedItemGenerator {
	private static Logger log = LogManager
			.getLogger(ParameterizedGenerator.class);
	private String ibatisQueryName = null;
	private Object parameters = null;

	public Object getParameters() {
		return parameters;
	}

	public void setParameters(Object parameters) {
		this.parameters = parameters;
	}

	/**
	 * An IBATIS query name string
	 * 
	 * @return
	 */
	public String getIbatisQueryName() {
		return ibatisQueryName;
	}

	public void setIbatisQueryName(String ibatisQueryName) {
		this.ibatisQueryName = ibatisQueryName;
	}

	@SuppressWarnings("unchecked")
	public List<?> getItems() throws ItemGeneratorException {
		List<?> tList = null;
		if (parameters == null) {
			throw new ItemGeneratorException("null parameters in "
					+ this.getClass().getName());
		}
		try {
			tList = getSqlMapClientTemplate().queryForList(
					getIbatisQueryName(), parameters);
		} catch (DataAccessException e) {
			throw new ItemGeneratorException("Data access problem "
					+ e.getMessage());

		} catch (Exception e) {
			throw new ItemGeneratorException("General generator problem "
					+ e.getMessage());
		}

		return tList;
	}

	public String getDescription() {

		return "Pass thru for " + getIbatisQueryName() + " with parms "
				+ parameters;
	}

}
