package com.dhenton9000.classic.generic.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dyh
 */

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateFactory {
	private static SessionFactory sessionFactory;
	private static Logger log = LogManager.getLogger(HibernateFactory.class);

	/**
	 * Constructs a new Singleton SessionFactory
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public static SessionFactory buildSessionFactory()
			throws HibernateException {
		if (sessionFactory != null) {
			closeFactory();
		}
		return configureSessionFactory();
	}

	/**
	 * Builds a SessionFactory, if it hasn't been already.
	 */
	public static SessionFactory buildIfNeeded()
			throws DataAccessLayerException {
		if (sessionFactory != null) {
			return sessionFactory;
		}
		try {
			return configureSessionFactory();
		} catch (HibernateException e) {
			throw new DataAccessLayerException(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session openSession() throws HibernateException {
		try {
			buildIfNeeded();
		} catch (DataAccessLayerException ex) {

			log.error("build if needed problem " + ex.getMessage());
		}

		if (sessionFactory.getCurrentSession() == null)
			return sessionFactory.openSession();
		else
			return sessionFactory.getCurrentSession();

	}

	public static void closeFactory() {
		if (sessionFactory != null) {
			try {
				sessionFactory.close();
			} catch (HibernateException ignored) {
				log.error("Couldn't close SessionFactory", ignored);
			}
		}
	}

	public static void close(Session session) {
		if (session != null) {
			try {
				if (session.isOpen())
					session.close();
			} catch (HibernateException ignored) {
				log.error("Couldn't close Session", ignored);
			}
		}
	}

	public static void rollback(Transaction tx) {
		try {
			if (tx != null) {
				tx.rollback();
			}
		} catch (HibernateException ignored) {
			log.error("Couldn't rollback Transaction", ignored);
		}
	}

	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	private static SessionFactory configureSessionFactory()
			throws HibernateException {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
	}

}
