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
 * as pouring meat into the meat grinder. This passes the query but does nothing
 * with parameters. Parameterization could be handled in the query or using
 * ParameterizedGenerator
 * 
 * @author Don
 */
public class PassThruGenerator extends SqlMapClientDaoSupport implements
		IFeedItemGenerator {
	private static Logger log = LogManager.getLogger(PassThruGenerator.class);
	private String ibatisQueryName = null;

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
		try {
			tList = getSqlMapClientTemplate()
					.queryForList(getIbatisQueryName());

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
		// TODO Auto-generated method stub
		return "Pass thru for " + getIbatisQueryName();
	}

}
