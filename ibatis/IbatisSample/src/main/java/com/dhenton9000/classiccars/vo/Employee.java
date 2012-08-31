package com.dhenton9000.classiccars.vo;

/**
 * AbstractEmployee entity provides the base persistence definition of the
 * Employee entity. @author eclipse Persistence Tools
 */

public  class Employee implements java.io.Serializable {

	// Fields

	private Integer employeenumber;
	private String lastname;
	private String firstname;
	private String extension;
	private String email;
	private Integer reportsto;
	private String jobtitle;
	private String officecode;

	// Constructors

	/** default constructor */
	public Employee() {
	}

	/** full constructor */
	public Employee(String lastname, String firstname,
			String extension, String email, Integer reportsto, String jobtitle) {

		this.lastname = lastname;
		this.firstname = firstname;
		this.extension = extension;
		this.email = email;
		this.reportsto = reportsto;
		this.jobtitle = jobtitle;
	}

	// Property accessors

	public Integer getEmployeenumber() {
		return this.employeenumber;
	}

	public void setEmployeenumber(Integer employeenumber) {
		this.employeenumber = employeenumber;
	}

	

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getReportsto() {
		return this.reportsto;
	}

	public void setReportsto(Integer reportsto) {
		this.reportsto = reportsto;
	}

	public String getJobtitle() {
		return this.jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public void setOfficecode(String officecode) {
		this.officecode = officecode;
	}

	public String getOfficecode() {
		return officecode;
	}

}