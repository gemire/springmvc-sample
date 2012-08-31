package com.dhenton9000.classic.generic.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

public class GenericHibernateDAO {
	private static Logger log = LogManager.getLogger(GenericHibernateDAO.class);

	public GenericHibernateDAO() {
		try {
			HibernateFactory.buildIfNeeded();
		} catch (DataAccessLayerException ex) {
			log.error("GenericHibernate DAO start problem "
					+ Utils.createErrorMessage(ex));
		}
	}

	public Object findById(Serializable id, Class clazz)
			throws DataAccessLayerException {
		log.debug("getting instance with id: " + id);
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateFactory.openSession();
			tx = session.beginTransaction();
			Object instance = session.get(clazz, id);
			tx.commit();
			return instance;
		} catch (Exception er) {
			HibernateFactory.rollback(tx);
			throw new DataAccessLayerException(Utils.createErrorMessage(er));
		}

		finally {
			HibernateFactory.close(session);
		}
	}

	public List findByExample(Object instance) throws DataAccessLayerException {
		log.debug("finding instance by example for "
				+ instance.getClass().getName());
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateFactory.openSession();
			tx = session.beginTransaction();
			List results = session.createCriteria(instance.getClass()).add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			HibernateFactory.rollback(tx);
			throw new DataAccessLayerException(Utils.createErrorMessage(re));
		} finally {
			HibernateFactory.close(session);
		}
	}

	public List findByProperty(String propertyName, String value, Class clazz)
			throws DataAccessLayerException {

		log.debug("finding instance by example for " + clazz.getName() + " "
				+ "finding Customer instance with property: " + propertyName
				+ ", value: " + value);

		Session session = null;
		Transaction tx = null;
		String itemName = clazz.getSimpleName();
		try {

			session = HibernateFactory.openSession();
			tx = session.beginTransaction();
			String queryString = "from " + itemName + " as model where model."
					+ propertyName + "= ?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, value);
			List items = queryObject.list();
			tx.commit();
			return items;
		} catch (RuntimeException re) {
			HibernateFactory.rollback(tx);
			throw new DataAccessLayerException(Utils.createErrorMessage(re));
		} finally {
			HibernateFactory.close(session);
		}
	}

	public Object merge(Object detachedInstance)
			throws DataAccessLayerException {

		log.debug("merging instance  " + detachedInstance.getClass().getName());
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateFactory.openSession();
			tx = session.beginTransaction();
			Object result = session.merge(detachedInstance);
			tx.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			HibernateFactory.rollback(tx);
			throw new DataAccessLayerException(Utils.createErrorMessage(re));
		} finally {
			HibernateFactory.close(session);
		}
	}

	public void attachDirty(Object detachedInstance)
			throws DataAccessLayerException {

		log.debug("attaching dirty for "
				+ detachedInstance.getClass().getName());
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(detachedInstance);
			tx.commit();
			log.debug("dirty attach successful");

		} catch (RuntimeException re) {
			HibernateFactory.rollback(tx);
			throw new DataAccessLayerException(Utils.createErrorMessage(re));
		} finally {
			HibernateFactory.close(session);
		}
	}

	public void attachClean(Object detachedInstance)
			throws DataAccessLayerException {

		log.debug("attaching clean for "
				+ detachedInstance.getClass().getName());
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateFactory.openSession();
			tx = session.beginTransaction();
			session.buildLockRequest(LockOptions.NONE).lock(detachedInstance);
			tx.commit();
			log.debug("clean attach successful");

		} catch (RuntimeException re) {
			HibernateFactory.rollback(tx);
			throw new DataAccessLayerException(Utils.createErrorMessage(re));
		} finally {
			HibernateFactory.close(session);
		}
	}

	public void save(Object detachedInstance) throws DataAccessLayerException {

		log.debug("save for " + detachedInstance.getClass().getName());
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateFactory.openSession();
			tx = session.beginTransaction();
			session.save(detachedInstance);
			tx.commit();
			log.debug("save successful");

		} catch (RuntimeException re) {
			HibernateFactory.rollback(tx);
			throw new DataAccessLayerException(Utils.createErrorMessage(re));
		} finally {
			HibernateFactory.close(session);
		}
	}

	public void delete(Object detachedInstance) throws DataAccessLayerException {

		log.debug("delete for " + detachedInstance.getClass().getName());
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateFactory.openSession();
			tx = session.beginTransaction();
			session.delete(detachedInstance);
			tx.commit();
			log.debug("delete successful");

		} catch (RuntimeException re) {
			HibernateFactory.rollback(tx);
			throw new DataAccessLayerException(Utils.createErrorMessage(re));
		} finally {
			HibernateFactory.close(session);
		}
	}

	public List findAll(Class clazz) throws DataAccessLayerException {
		List objects = null;

		log.debug("findAll for " + clazz.getName());
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from " + clazz.getName());
			objects = query.list();
			tx.commit();
		} catch (RuntimeException re) {
			HibernateFactory.rollback(tx);
			throw new DataAccessLayerException(Utils.createErrorMessage(re));
		} finally {
			HibernateFactory.close(session);
		}
		return objects;
	}

	public void deleteByExample(Object example) throws DataAccessLayerException {
		log.debug("delete by example for " + example.getClass().getName());
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateFactory.openSession();
			tx = session.beginTransaction();
			List results = session.createCriteria(example.getClass()).add(
					Example.create(example)).list();
			log.debug("delete by example successful, result size: "
					+ results.size());

			Iterator iter = results.iterator();

			while (iter.hasNext()) {
				Object o = iter.next();
				session.delete(o);
			}
			tx.commit();

		} catch (RuntimeException re) {
			HibernateFactory.rollback(tx);
			throw new DataAccessLayerException(Utils.createErrorMessage(re));
		} finally {
			HibernateFactory.close(session);
		}

	}

	public void evict(Object o) {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateFactory.openSession();
			tx = session.beginTransaction();
			session.evict(o);
			tx.commit();

		} catch (RuntimeException re) {
			HibernateFactory.rollback(tx);
			throw new DataAccessLayerException(Utils.createErrorMessage(re));
		} finally {
			HibernateFactory.close(session);
		}

	}

}
