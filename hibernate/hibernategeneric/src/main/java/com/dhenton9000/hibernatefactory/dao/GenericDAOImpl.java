package com.dhenton9000.hibernatefactory.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.dhenton9000.generic.DataAccessLayerException;
import com.dhenton9000.generic.GenericDAO;
import com.dhenton9000.generic.Utils;


@SuppressWarnings("unchecked")
/**
 * This is an abstract DAO implementation using generics and a HibernateFactory. This can 
 * be extended to create various DAOs
 */
public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {
	private static Logger log = LogManager.getLogger(GenericDAOImpl.class);
	private Class<T> persistenceClass = null;
	private Session session = null;

	public GenericDAOImpl() {
		try {
			HibernateFactory.buildIfNeeded();
		} catch (DataAccessLayerException ex) {
			log.error("GenericHibernate DAO start problem "
					+ Utils.createErrorMessage(ex));
		}

		this.persistenceClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	 
	
	protected Session getHibernateSession() {


		session = HibernateFactory.openSession();
		return session;
	}

	/* (non-Javadoc)
	 * @see com.dhenton9000.hibernatefactory.dao.GenericDAO#emptyTable()
	 */
	public void emptyTable() throws DataAccessLayerException {

		log.debug("emptying table");
		Session session = null;
		Transaction tx = null;

		try {
			session = getHibernateSession();
			tx = session.beginTransaction();

			Query query = session.createQuery("delete from "
					+ getPersistenceClass().getCanonicalName());
			int var = query.executeUpdate();
			log.debug("emptyTable deleted "+var+" records ");

			 
			tx.commit();

		} catch (Exception er) {
			HibernateFactory.rollback(tx);
			throw new DataAccessLayerException(Utils.createErrorMessage(er));
		}

		finally {
			HibernateFactory.close(session);
		}

	}

	/* (non-Javadoc)
	 * @see com.dhenton9000.hibernatefactory.dao.GenericDAO#findById(ID)
	 */
	public T findById(ID id) throws DataAccessLayerException {
		log.debug("getting instance with id: " + id);
		Session session = null;
		Transaction tx = null;

		try {
			session = getHibernateSession();
			tx = session.beginTransaction();
			T instance = (T) session.get(getPersistenceClass(), id);
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

	/* (non-Javadoc)
	 * @see com.dhenton9000.hibernatefactory.dao.GenericDAO#attachClean(T)
	 */
	public void attachClean(T detachedInstance) throws DataAccessLayerException {

		
		log.debug("attaching clean for "
				+ detachedInstance.getClass().getName());
		Session session = null;
		Transaction tx = null;
		try {
			session = getHibernateSession();
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

	/* (non-Javadoc)
	 * @see com.dhenton9000.hibernatefactory.dao.GenericDAO#save(T)
	 */
	public void save(T detachedInstance) throws DataAccessLayerException {

		log.debug("save for " + detachedInstance.getClass().getName());
		Session session = null;
		Transaction tx = null;
		try {
			session = getHibernateSession();
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

        
	public void saveOrUpdate(T detachedInstance) throws DataAccessLayerException {

		log.debug("save or update for " + detachedInstance.getClass().getName());
		Session session = null;
		Transaction tx = null;
		try {
			session = getHibernateSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(detachedInstance);
			tx.commit();
			log.debug("save or update successful");

		} catch (RuntimeException re) {
			HibernateFactory.rollback(tx);
			throw new DataAccessLayerException(Utils.createErrorMessage(re));
		} finally {
			HibernateFactory.close(session);
		}
	}
       
        
        public T merge(T detachedInstance) throws DataAccessLayerException {

		log.debug("merge for " + detachedInstance.getClass().getName());
		Session session = null;
                T r = null;
		Transaction tx = null;
		try {
			session = getHibernateSession();
			tx = session.beginTransaction();
			r = (T) session.merge(detachedInstance);
			tx.commit();
			log.debug("merge successful");
                        

		} catch (RuntimeException re) {
			HibernateFactory.rollback(tx);
			throw new DataAccessLayerException(Utils.createErrorMessage(re));
		} finally {
			HibernateFactory.close(session);
		}
                return r;
	}
       
        
	// ///////////////////////

	/* (non-Javadoc)
	 * @see com.dhenton9000.hibernatefactory.dao.GenericDAO#delete(T)
	 */
	public void delete(T detachedInstance) throws DataAccessLayerException {

		log.debug("delete for " + detachedInstance.getClass().getName());
		Session session = null;
		Transaction tx = null;
		try {
			session = getHibernateSession();
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

	/* (non-Javadoc)
	 * @see com.dhenton9000.hibernatefactory.dao.GenericDAO#findAll()
	 */
	public List<T> findAll() throws DataAccessLayerException {
		List<T> objects = null;

		log.debug("findAll for " + getPersistenceClass().getCanonicalName());
		Session session = null;
		Transaction tx = null;

		try {
			session = getHibernateSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from "
					+ getPersistenceClass().getCanonicalName());
			objects = (List<T>) query.list();
			tx.commit();
		} catch (RuntimeException re) {
			HibernateFactory.rollback(tx);
			throw new DataAccessLayerException(Utils.createErrorMessage(re));
		} finally {
			HibernateFactory.close(session);
		}
		return objects;
	}

	/* (non-Javadoc)
	 * @see com.dhenton9000.hibernatefactory.dao.GenericDAO#deleteByExample(T)
	 */
	public void deleteByExample(T example) throws DataAccessLayerException {
		log.debug("delete by example for " + example.getClass().getName());
		Session session = null;
		Transaction tx = null;

		try {
			session = getHibernateSession();
			tx = session.beginTransaction();
			List<T> results = (List<T>) session.createCriteria(
					example.getClass()).add(Example.create(example)).list();
			log.debug("delete by example successful, result size: "
					+ results.size());

			Iterator<T> iter = results.iterator();

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

	/* (non-Javadoc)
	 * @see com.dhenton9000.hibernatefactory.dao.GenericDAO#evict(T)
	 */
	public void evict(T o) {
		Session session = null;
		Transaction tx = null;

		try {
			session = getHibernateSession();
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

	/* (non-Javadoc)
	 * @see com.dhenton9000.hibernatefactory.dao.GenericDAO#getPersistenceClass()
	 */
	public Class<T> getPersistenceClass() {
		return persistenceClass;
	}

}
