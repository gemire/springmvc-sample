/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.feeds;

import java.util.List;

/**
 *
 * @author Don
 */
public interface IFeedItemGenerator {

	/**
	 * Generate a list of items for the feed. These are POJOs with get/set methods
	 * such as might come from Hibernate or IBATIS
	 * @return the list of items to process
	 * @throws ItemGeneratorException
	 */
    public List getItems() throws ItemGeneratorException;
    /**
     * Return a description of the generator
     * @return
     */
    public String getDescription();
    
}
