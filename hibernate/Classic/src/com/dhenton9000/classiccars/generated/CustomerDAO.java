package com.dhenton9000.classiccars.generated;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * A data access object (DAO) providing persistence and search support for
 * Customer entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.dhenton9000.classiccars.generated.Customer
 * @author eclipse Persistence Tools
 */

public class CustomerDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(CustomerDAO.class);
	// property constants
	public static final String CUSTOMERNAME = "customername";
	public static final String CONTACTLASTNAME = "contactlastname";
	public static final String CONTACTFIRSTNAME = "contactfirstname";
	public static final String PHONE = "phone";
	public static final String ADDRESSLINE1 = "addressline1";
	public static final String ADDRESSLINE2 = "addressline2";
	public static final String CITY = "city";
	public static final String STATE = "state";
	public static final String POSTALCODE = "postalcode";
	public static final String COUNTRY = "country";
	public static final String SALESREPEMPLOYEENUMBER = "salesrepemployeenumber";
	public static final String CREDITLIMIT = "creditlimit";
	private PlatformTransactionManager transactionManager = null;

	protected void initDao() {
		// do nothing
	}

	public void save(final Customer transientInstance) {
		log.debug("saving Customer instance");

		TransactionTemplate transactionTemplate = new TransactionTemplate(
				transactionManager);

		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			public void doInTransactionWithoutResult(TransactionStatus status) {

				try {

					getHibernateTemplate().save(transientInstance);

					log.debug("save successful");
				} catch (RuntimeException re) {
					log.error("save failed", re);
					throw re;
				}

			}// ////
		});

	}

	public void delete(final Customer persistentInstance) {
		log.debug("deleting Customer instance");
		TransactionTemplate transactionTemplate = new TransactionTemplate(
				transactionManager);

		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			public void doInTransactionWithoutResult(TransactionStatus status) {

				try {
					getHibernateTemplate().delete(persistentInstance);
					log.debug("delete successful");
				} catch (RuntimeException re) {
					log.error("delete failed", re);
					throw re;
				}

			}// ////
		});

	}

	public Customer findById(java.lang.Integer id) {
		log.debug("getting Customer instance with id: " + id);
		try {
			Customer instance = (Customer) getHibernateTemplate().get(
					"com.dhenton9000.classiccars.generated.Customer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Customer instance) {
		log.debug("finding Customer instance by example");
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
		log.debug("finding Customer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Customer as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCustomername(Object customername) {
		return findByProperty(CUSTOMERNAME, customername);
	}

	public List findByContactlastname(Object contactlastname) {
		return findByProperty(CONTACTLASTNAME, contactlastname);
	}

	public List findByContactfirstname(Object contactfirstname) {
		return findByProperty(CONTACTFIRSTNAME, contactfirstname);
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

	public List findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findByPostalcode(Object postalcode) {
		return findByProperty(POSTALCODE, postalcode);
	}

	public List findByCountry(Object country) {
		return findByProperty(COUNTRY, country);
	}

	public List findBySalesrepemployeenumber(Object salesrepemployeenumber) {
		return findByProperty(SALESREPEMPLOYEENUMBER, salesrepemployeenumber);
	}

	public List findByCreditlimit(Object creditlimit) {
		return findByProperty(CREDITLIMIT, creditlimit);
	}

	public List findAll() {
		log.debug("finding all Customer instances");
		try {
			String queryString = "from Customer";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Customer merge(final Customer detachedInstance) {
		log.debug("merging Customer instance");

		TransactionTemplate transactionTemplate = new TransactionTemplate(
				transactionManager);

		Object ret = transactionTemplate.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {

				try {
					Customer result = (Customer) getHibernateTemplate().merge(
							detachedInstance);
					log.debug("merge successful");
					return result;
				} catch (RuntimeException re) {
					log.error("merge failed", re);
					throw re;
				}

			}// ////
		});

		return (Customer) ret;

	}

	public void attachDirty(Customer instance) {
		log.debug("attaching dirty Customer instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Customer instance) {
		log.debug("attaching clean Customer instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CustomerDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CustomerDAO) ctx.getBean("CustomerDAO");
	}

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(
			PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
}