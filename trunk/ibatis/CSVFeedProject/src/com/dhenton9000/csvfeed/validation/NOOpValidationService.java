package com.dhenton9000.csvfeed.validation;

import com.dhenton9000.feeds.ItemValidationService;
/**
 * validator that passes thru all submitted objects
 * @author dyh
 *
 */
public class NOOpValidationService implements ItemValidationService {

	public boolean validate(Object item) {
		 return true;
	}

}
