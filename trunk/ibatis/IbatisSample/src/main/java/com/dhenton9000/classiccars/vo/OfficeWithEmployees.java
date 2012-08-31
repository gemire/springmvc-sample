package com.dhenton9000.classiccars.vo;

import java.util.Collection;

public class OfficeWithEmployees extends Office {
	private Collection employees;
	
	public void setEmployees(Collection employees) {
		this.employees = employees;
	}

	public Collection getEmployees() {
		return employees;
	}
}
