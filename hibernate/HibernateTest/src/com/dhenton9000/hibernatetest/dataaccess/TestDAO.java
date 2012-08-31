package com.dhenton9000.hibernatetest.dataaccess;

import java.io.Serializable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.dhenton9000.hibernatetest.Utils;
import com.dhenton9000.hibernatetest.generated.BillingDetails;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDAO {

	private static Logger log = LogManager.getLogger(TestDAO.class);

	private static TestDAO instance = null;

	// ~--- constructors
	// ---------------------------------------------------------
	/**
	 * 
	 * The constructor initializes the factory
	 */
	private TestDAO() {
		try {
			HibernateFactory.buildIfNeeded();
		} catch (DataAccessLayerException ex) {
			log.error("Test DAO start problem " + Utils.createErrorMessage(ex));
		}
	}

	// ~--- methods
	// --------------------------------------------------------------
	/**
	 * Method description TODO
	 * 
	 * 
	 * @return
	 */
	public static synchronized TestDAO getInstance() {
		if (instance == null) {
			instance = new TestDAO();
		}

		return instance;
	}

	/**
	 * save or update the object save if new update if already present
	 * 
	 * @param obj
	 * 
	 * @throws DataAccessLayerException
	 *             if during an update the key is violated or on general error
	 */
	public void saveOrUpdate(Object obj) throws DataAccessLayerException {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(obj);
			tx.commit();
		} catch (ConstraintViolationException er) {
			HibernateFactory.rollback(tx);

			throw new DataAccessLayerException(
					"Could not update, duplicate key");
		} catch (Exception e) {
			HibernateFactory.rollback(tx);

			throw new DataAccessLayerException(Utils.createErrorMessage(e));
		} finally {
			HibernateFactory.close(session);
		}
	}

	public BillingDetails getBillingDetails(int i)
			throws DataAccessLayerException {
		Session session = null;
		Transaction tx = null;
		BillingDetails det = null;
		try {
			session = HibernateFactory.openSession();
			tx = session.beginTransaction();
			det = (BillingDetails) session.get(BillingDetails.class,
					new Long(i));
			tx.commit();
		} catch (Exception er) {
			HibernateFactory.rollback(tx);

			throw new DataAccessLayerException(Utils.createErrorMessage(er));
		}

		finally {
			HibernateFactory.close(session);
		}

		return det;

	}

}
