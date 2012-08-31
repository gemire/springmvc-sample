package com.dhenton9000.classiccars.generated;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Office entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.dhenton9000.classiccars.generated.Office
 * @author eclipse Persistence Tools
 */

public class OfficeDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(OfficeDAO.class);
	// property constants
	public static final String CITY = "city";
	public static final String PHONE = "phone";
	public static final String ADDRESSLINE1 = "addressline1";
	public static final String ADDRESSLINE2 = "addressline2";
	public static final String STATE = "state";
	public static final String COUNTRY = "country";
	public static final String POSTALCODE = "postalcode";
	public static final String TERRITORY = "territory";

	protected void initDao() {
		// do nothing
	}

	public void save(Office transientInstance) {
		log.debug("saving Office instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Office persistentInstance) {
		log.debug("deleting Office instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Office findById(java.lang.String id) {
		log.debug("getting Office instance with id: " + id);
		try {
			Office instance = (Office) getHibernateTemplate().get(
					"com.dhenton9000.classiccars.generated.Office", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Office instance) {
		log.debug("finding Office instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Office instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Office as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByAddressline1(Object addressline1) {
		return findByProperty(ADDRESSLINE1, addressline1);
	}

	public List findByAddressline2(Object addressline2) {
		return findByProperty(ADDRESSLINE2, addressline2);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findByCountry(Object country) {
		return findByProperty(COUNTRY, country);
	}

	public List findByPostalcode(Object postalcode) {
		return findByProperty(POSTALCODE, postalcode);
	}

	public List findByTerritory(Object territory) {
		return findByProperty(TERRITORY, territory);
	}

	public List findAll() {
		log.debug("finding all Office instances");
		try {
			String queryString = "from Office";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Office merge(Office detachedInstance) {
		log.debug("merging Office instance");
		try {
			Office result = (Office) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Office instance) {
		log.debug("attaching dirty Office instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Office instance) {
		log.debug("attaching clean Office instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OfficeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OfficeDAO) ctx.getBean("OfficeDAO");
	}
}