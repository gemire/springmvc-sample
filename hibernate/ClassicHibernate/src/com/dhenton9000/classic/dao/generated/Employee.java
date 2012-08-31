package com.dhenton9000.classic.dao.generated;

/**
 * Employee entity. @author eclipse Persistence Tools
 */

public class Employee implements java.io.Serializable {

	// Fields

	private Integer employeenumber;
	private Office office;
	private String lastname;
	private String firstname;
	private String extension;
	private String email;
	private Integer reportsto;
	private String jobtitle;

	// Constructors

	/** default constructor */
	public Employee() {
	}

	/** full constructor */
	public Employee(Office office, String lastname, String firstname,
			String extension, String email, Integer reportsto, String jobtitle) {
		this.office = office;
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

	public Office getOffice() {
		return this.office;
	}

	public void setOffice(Office office) {
		this.office = office;
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

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((extension == null) ? 0 : extension.hashCode());
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result
				+ ((jobtitle == null) ? 0 : jobtitle.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((office == null) ? 0 : office.hashCode());
		result = prime * result
				+ ((reportsto == null) ? 0 : reportsto.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (extension == null) {
			if (other.extension != null)
				return false;
		} else if (!extension.equals(other.extension))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (jobtitle == null) {
			if (other.jobtitle != null)
				return false;
		} else if (!jobtitle.equals(other.jobtitle))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (office == null) {
			if (other.office != null)
				return false;
		} else if (!office.equals(other.office))
			return false;
		if (reportsto == null) {
			if (other.reportsto != null)
				return false;
		} else if (!reportsto.equals(other.reportsto))
			return false;
		return true;
	}

}