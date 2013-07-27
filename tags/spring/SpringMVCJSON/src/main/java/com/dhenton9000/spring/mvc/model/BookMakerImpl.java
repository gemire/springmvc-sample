package com.dhenton9000.spring.mvc.model;

public class BookMakerImpl implements BookMaker {

	/* (non-Javadoc)
	 * @see com.dhenton9000.spring.mvc.model.BookMaker#getBook()
	 */
	public Book getBook()
	{
		return new Book();
	}
	
	
	public String toString()
	{
		return "Bookmaker!!!!!!!";
	}
}
