package com.dhenton9000.ibatis.dao;

import java.util.List;

import com.dhenton9000.classiccars.parms.CountryStateParameter;
import com.dhenton9000.classiccars.vo.Customer;
import com.dhenton9000.classiccars.vo.Office;
import com.dhenton9000.classiccars.vo.OfficeWithEmployees;

public interface IClassicCarsDAO {

	
	public Office getOfficeByCode(String officeCode) ;
	public List<Office> getAllOffices() ;
	public OfficeWithEmployees getOfficeByCodeWithEmployees(String officeCode);
	public List<Customer> getCustomerByCountryState(CountryStateParameter parms);
	public int deleteOffice (String officecode);
	public void addOffice(Office f);
	public void transactionTestInsertOffice(Office t)  ;
	
}
