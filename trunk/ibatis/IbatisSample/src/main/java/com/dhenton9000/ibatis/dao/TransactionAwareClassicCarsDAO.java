package com.dhenton9000.ibatis.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.dhenton9000.classiccars.parms.CountryStateParameter;
import com.dhenton9000.classiccars.vo.Customer;
import com.dhenton9000.classiccars.vo.Office;
import com.dhenton9000.classiccars.vo.OfficeWithEmployees;

@SuppressWarnings("unchecked")
public class TransactionAwareClassicCarsDAO extends SqlMapClientDaoSupport
		implements TransactedIClassicCarsDAO {
	private static Logger log = LogManager
			.getLogger(TransactionAwareClassicCarsDAO.class);

	private PlatformTransactionManager transactionManager = null;

	public void setTransactionManager(
			PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void insertOfficeTransacted(final Office o) {

		log.info("-- insert rollback");
		final TransactionTemplate tt = new TransactionTemplate(this.getTransactionManager());
		tt.setReadOnly(false);
		tt.execute(new TransactionCallbackWithoutResult() {
			public void doInTransactionWithoutResult(TransactionStatus status) {
				log.info("-- doInTransactionWithoutResult -- expects transaction rollback");
				// do stuff
				o.setAddressline1("fred");
				status.setRollbackOnly();
			}
		});

	}

}