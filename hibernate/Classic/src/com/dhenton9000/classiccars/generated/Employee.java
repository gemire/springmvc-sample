package com.dhenton9000.classiccars.generated;

/**
 * Employee entity. @author eclipse Persistence Tools
 */
public class Employee extends AbstractEmployee implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Employee() {
	}

	/** full constructor */
	public Employee(Office office, String lastname, String firstname,
			String extension, String email, Integer reportsto, String jobtitle) {
		super(office, lastname, firstname, extension, email, reportsto,
				jobtitle);
	}

}
