package com.dhenton9000.forms;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

public class DemoForm extends ActionForm {

	private static final String DATE_FORMAT = "MM/dd/yy";
	/**
	 * 
	 */
	private static final long serialVersionUID = 2593682658250226791L;
	private String phone;
	private String city;
	private String state = null;
	private int country = 0;
	private boolean firstTime = true;
	private static final Logger log = Logger.getLogger(DemoForm.class);
	private static final DateFormat df = new SimpleDateFormat(DATE_FORMAT);

	private String paymentDate = null;
	private int customerNumber;
	private String productName;
	private final ArrayList countryList = new ArrayList();
	private String[] selectedProductTypes = {};
	private   LabelValueBean[] productTypes = new LabelValueBean[3];
	
	

	public DemoForm() {
		countryList.add(new CountryItem("USA", 1));
		countryList.add(new CountryItem("Germany", 2));
		countryList.add(new CountryItem("Brazil", 3));
		countryList.add(new CountryItem("Sandwich Islands", 4));
		countryList.add(new CountryItem("Denmark", 5));
		countryList.add(new CountryItem("Republic of Togo", 6));
		
	
		productTypes[0] = new LabelValueBean("aaa","111");
		productTypes[1] = new LabelValueBean("bbb","222");
		productTypes[2] = new LabelValueBean("ccc","333");
		
		
	}

	/**
	 * this is called every time the form is submitted so if this 
	 * bean is used for a multi page form, this should only be called
	 * once.
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	
		if (firstTime) {
			java.util.Date d = new java.util.Date();
			paymentDate = df.format(d);
			country = 0;
			firstTime = false;
		}
		
	//	selectedProductTypes =null; this will always return the array to empty
	// on the multipart form
		
		
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (getPaymentDate() == null || !isValidDate(getPaymentDate())) {
			errors.add("step2.invalidDate", new ActionError("demo.invalid.date",
					getPaymentDate()));
			log.error("added " + getPaymentDate() + " as an error");
		}
		if (country == 0) {
			errors.add("step1.invalidCountry",
					new ActionError("demo.invalid.country"));
		}
		if (state == null) {
			errors.add("step1.invalidState",
					new ActionError("demo.invalid.state"));
			log.error("added invalid state");
			
		}
		return errors;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getCountry() {
		log.debug("getcountry " + country);
		return country;
	}

	public void setCountry(int country) {
		log.debug("setcountry " + country);
		this.country = country;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ArrayList getCountryList() {
		return countryList;
	}

	
	/**
	 * determine if a date string is valid
	 * @param dateVar
	 * @return
	 */
	private boolean isValidDate(String dateVar) {
		boolean isOkay = false;
		Date d = null;
		try {
			d = df.parse(dateVar);
		} catch (ParseException e) {

		}

		if (d != null) {
			isOkay = true;
		}

		return isOkay;
	}

	public void setProductTypes(LabelValueBean[] productTypes) {
		this.productTypes = productTypes;
	}

	public LabelValueBean[] getProductTypes() {
		return productTypes;
	}

	public void setSelectedProductTypes(String[] selectedProductTypes) {
		this.selectedProductTypes = selectedProductTypes;
	}

	public String[] getSelectedProductTypes() {
		return selectedProductTypes;
	}

	
}
