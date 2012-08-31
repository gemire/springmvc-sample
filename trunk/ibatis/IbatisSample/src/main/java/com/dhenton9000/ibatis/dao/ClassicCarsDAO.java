package com.dhenton9000.ibatis.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.dhenton9000.classiccars.parms.CountryStateParameter;
import com.dhenton9000.classiccars.vo.Customer;
import com.dhenton9000.classiccars.vo.Office;
import com.dhenton9000.classiccars.vo.OfficeWithEmployees;

@SuppressWarnings("unchecked")
public class ClassicCarsDAO extends SqlMapClientDaoSupport implements
		IClassicCarsDAO {
	private static Logger log = LogManager.getLogger(ClassicCarsDAO.class);

	public Office getOfficeByCode(String officeCode) {

		Office officeList = (Office) getSqlMapClientTemplate().queryForObject(
				"getOfficeByCode", officeCode);
		return officeList;
	}

	public List<Office> getAllOffices() {

		List<Office> officeList = getSqlMapClientTemplate().queryForList(
				"getAllOffices");

		return officeList;

	}

	public OfficeWithEmployees getOfficeByCodeWithEmployees(String officeCode) {
		OfficeWithEmployees officeList = (OfficeWithEmployees) getSqlMapClientTemplate()
				.queryForObject("getOfficeByCodeWithEmployees", officeCode);
		return officeList;
	}

	public List<Customer> getCustomerByCountryState(CountryStateParameter parms) {

		List<Customer> customerList = getSqlMapClientTemplate().queryForList(
				"getCustomerByCountryState", parms);

		return customerList;

	}

	public void addOffice(Office f) {

		 getSqlMapClientTemplate().insert("officeInsert", f);
		
		
	}
	 

	public int deleteOffice(String officecode) {
		return getSqlMapClientTemplate().delete("officeDelete", officecode);

	}
	/**
	 * checked exceptions will NOT be rolled back unless specifically marked
	 * see http://static.springsource.org/spring/docs/2.0.8/reference/transaction.html
	 */
	public void transactionTestInsertOffice(Office t)  
	{
		throw new UnsupportedOperationException();

	}

}