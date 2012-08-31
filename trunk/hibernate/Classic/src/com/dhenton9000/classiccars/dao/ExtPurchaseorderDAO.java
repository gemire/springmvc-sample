package com.dhenton9000.classiccars.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import com.dhenton9000.classiccars.generated.PurchaseorderDAO;

public class ExtPurchaseorderDAO extends PurchaseorderDAO {

	private static final Log log = LogFactory.getLog(PurchaseorderDAO.class);

	public List getPurchaseOrdersForCustomer(int custId) {
		log.debug("finding all Purchaseorder instances for custId " + custId);

		String queryString = "from Purchaseorder as po  "
				+ "inner join fetch po.customer as cust  "
				+ "inner join fetch po.orderdetails as order_details  "
				+ "inner join fetch order_details.product as product  "
				+ "where cust.customernumber = :cust_num  "
		        + "order by po.orderdate, order_details.orderlinenumber ";
		try {

			return getHibernateTemplate().findByNamedParam(queryString,
					"cust_num", new Integer(custId));
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	
	public static ExtPurchaseorderDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ExtPurchaseorderDAO) ctx.getBean("PurchaseorderDAO");
	}
	
	
	
}
