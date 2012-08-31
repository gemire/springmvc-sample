package com.dhenton9000.hibernate.concurrency;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dhenton9000.classic.generic.dao.DataAccessLayerException;
import com.dhenton9000.classic.generic.dao.GenericHibernateDAO;
import com.dhenton9000.hibernate.concurrency.generated.Users;



public class ConcurrencyDemo {
	private static Logger log = LogManager.getLogger(ConcurrencyDemo.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ConcurrencyDemo cD = new ConcurrencyDemo();
		cD.doUserMod();

	}
	
	
	private void doUserMod() {
		GenericHibernateDAO dao = new GenericHibernateDAO();
		// get a user
		Users u = (Users) dao.findById(new String("dhh"), Users.class);
		// detach it from the session
		dao.evict(u);
		// modify it
		u.setUsername(u.getUsername()+"x");
		
	
		// perform an update
		log.debug("starting new save");
		Users u2 = (Users) dao.findById(new String("dhh"), Users.class);
		u2.setUsername(u.getUsername()+"x1");
		dao.attachDirty(u2);
		log.debug("did save 2");
		log.debug("starting save 1");
		
		// now try the original update
		/**
		 * this will result in a stale data exception which has been wrapped
		 * in a DataAccessLayerException
		 */
		try {
			dao.merge(u);
		} catch (DataAccessLayerException e) {
			log.error("Merge produced "+e.getMessage());
		}
		log.debug("finished save/merge 1");
		
	}
	
	 
	
	
	
	

}
