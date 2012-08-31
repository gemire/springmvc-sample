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
 * Product entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.dhenton9000.classiccars.generated.Product
 * @author eclipse Persistence Tools
 */

public class ProductDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(ProductDAO.class);
	// property constants
	public static final String PRODUCTNAME = "productname";
	public static final String PRODUCTLINE = "productline";
	public static final String PRODUCTSCALE = "productscale";
	public static final String PRODUCTVENDOR = "productvendor";
	public static final String PRODUCTDESCRIPTION = "productdescription";
	public static final String QUANTITYINSTOCK = "quantityinstock";
	public static final String BUYPRICE = "buyprice";
	public static final String MSRP = "msrp";

	protected void initDao() {
		// do nothing
	}

	public void save(Product transientInstance) {
		log.debug("saving Product instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Product persistentInstance) {
		log.debug("deleting Product instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Product findById(java.lang.String id) {
		log.debug("getting Product instance with id: " + id);
		try {
			Product instance = (Product) getHibernateTemplate().get(
					"com.dhenton9000.classiccars.generated.Product", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Product instance) {
		log.debug("finding Product instance by example");
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
		log.debug("finding Product instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Product as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProductname(Object productname) {
		return findByProperty(PRODUCTNAME, productname);
	}

	public List findByProductline(Object productline) {
		return findByProperty(PRODUCTLINE, productline);
	}

	public List findByProductscale(Object productscale) {
		return findByProperty(PRODUCTSCALE, productscale);
	}

	public List findByProductvendor(Object productvendor) {
		return findByProperty(PRODUCTVENDOR, productvendor);
	}

	public List findByProductdescription(Object productdescription) {
		return findByProperty(PRODUCTDESCRIPTION, productdescription);
	}

	public List findByQuantityinstock(Object quantityinstock) {
		return findByProperty(QUANTITYINSTOCK, quantityinstock);
	}

	public List findByBuyprice(Object buyprice) {
		return findByProperty(BUYPRICE, buyprice);
	}

	public List findByMsrp(Object msrp) {
		return findByProperty(MSRP, msrp);
	}

	public List findAll() {
		log.debug("finding all Product instances");
		try {
			String queryString = "from Product";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Product merge(Product detachedInstance) {
		log.debug("merging Product instance");
		try {
			Product result = (Product) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Product instance) {
		log.debug("attaching dirty Product instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Product instance) {
		log.debug("attaching clean Product instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ProductDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ProductDAO) ctx.getBean("ProductDAO");
	}
}