/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.csvfeed;

/**
 * Base class for all generic CSV columns
 * @author Don
 */
public abstract class FeedColumn {

	private String header = null;

	/**
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * @param header
	 *            the header to set
	 */
	public void setHeader(String header) {
		this.header = header;
	}

	/**
	 * This method must be overwritten. It will take the object passed in which
	 * is a POJO for a row in a database or extracted xml. It will have to cast
	 * to the known type, for example the VO from ibatis. Then it will have to
	 * read the properties of the object and return the value that goes into the
	 * CSV at this column position.
	 * 
	 * @param item
	 * @return
	 */
	abstract public String getValue(Object item);

	/**
	 * A static method for clean trailing and leading whitespace
	 * @param t
	 * @return
	 */
	@SuppressWarnings("unused")
	public static String stripSpace(String t) {
		String el = new String(t);
		if (el == null) {
			el = "";
		} else {
			el = el.replaceAll("^\\s+", "");
			el = el.replaceAll("\\s+$", "");

		}

		return el;
	}
}
