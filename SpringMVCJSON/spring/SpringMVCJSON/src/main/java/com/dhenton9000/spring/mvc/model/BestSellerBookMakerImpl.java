package com.dhenton9000.spring.mvc.model;

public class BestSellerBookMakerImpl implements BookMaker {

	/* (non-Javadoc)
	 * @see com.dhenton9000.spring.mvc.model.BookMaker#getBook()
	 */
	public Book getBook()
	{
		Book t = new Book();
		t.setAuthor("Joesf Heller");
		t.setTitle("Catch-22");
		return t;
	}
	
	
	public String toString()
	{
		return "BestSeller!!!!!!!";
	}
}
