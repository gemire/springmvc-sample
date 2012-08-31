/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.csvfeed;

import com.dhenton9000.feeds.FeedException;
import com.dhenton9000.feeds.IFeedController;
import com.dhenton9000.feeds.IFeedItemGenerator;
import com.dhenton9000.feeds.ItemGeneratorException;
import com.dhenton9000.feeds.ItemValidationService;

import java.util.ArrayList;
import java.util.LinkedList;
import com.infomata.data.DataFile;
import com.infomata.data.DataRow;
import com.infomata.data.SimpleDelimiterFormat;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * A generalized Feed Controller. This class is responsible
 * for actually forming the CSV file. It validates the entries
 * and uses the column collection to format the entries per
 * row
 * @author Don
 */
public class BaseCSVFeedController implements IFeedController {

	private String fullFileLocation = null;
	private LinkedList<FeedColumn> columns = null;
	private boolean usingHeaders = true;
	private String delimiterCharacter = "|";
	private ArrayList<IFeedItemGenerator> generators = new ArrayList<IFeedItemGenerator>();
	private String encoding = "UTF-8";
	private static Logger log = LogManager
			.getLogger(BaseCSVFeedController.class);
	private ItemValidationService validationService = null;

	
	
	/**
	 * a validation service checks that the row is legal for 
	 * entering the CSV file. It is required. If you don't want to 
	 * validate, then use {@link com.dhenton9000.csvfeed.validation.NOOPValidationService}
	 * 
	 * @return
	 */
	public ItemValidationService getValidationService() {
		return validationService;
	}

	public void setValidationService(ItemValidationService validationService) {
		this.validationService = validationService;
	}

	/**
	 * @return the fullFileLocation
	 */
	public String getFullFileLocation() {
		return fullFileLocation;
	}

	/**
	 * @param fullFileLocation
	 *            the fullFileLocation to set
	 */
	public void setFullFileLocation(String fullFileLocation) {
		this.fullFileLocation = fullFileLocation;
	}

	/**
	 * injected linked list of columns that will act as command
	 * objects for finally formatting the column data
	 * @return the columns
	 */
	public LinkedList<FeedColumn> getColumns() {
		return columns;
	}

	/**
	 * @param columns
	 *            the columns to set
	 */
	public void setColumns(LinkedList<FeedColumn> columns) {
		this.columns = columns;
	}

	/**
	 * true if using headers false if not
	 * @return the usingHeaders
	 */
	public boolean isUsingHeaders() {
		return usingHeaders;
	}

	/**
	 * @param usingHeaders
	 *            the usingHeaders to set
	 */
	public void setUsingHeaders(boolean usingHeaders) {
		this.usingHeaders = usingHeaders;
	}

	/**
	 * A collection of generators, so that more than one source
	 * can be accumulated into the CSV file
	 * 
	 * @return the generators
	 */
	public ArrayList<IFeedItemGenerator> getGenerators() {
		return generators;
	}

	/**
	 * This returns the writer, ready but not pointing to a file
	 * 
	 * @return
	 */
	protected DataFile createFeedFile() {

		DataFile write = DataFile.createWriter(getEncoding(), false);

		write.setDataFormat(new SimpleDelimiterFormat(getDelimiterCharacter(),
				"\\"));
		return write;

	}

	/**
	 * @param generators
	 *            the generators to set
	 */
	public void setGenerators(ArrayList<IFeedItemGenerator> generators) {
		this.generators = generators;
	}

	/**
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * @param encoding
	 *            the encoding to set
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/**
	 * The main feed implementation method
	 */
	public void createFeed() throws FeedException {

		List items = null;
		DataFile write = null;
		
		if (validationService == null)
		{
			throw new RuntimeException("validation service is null");
		}

		try {
			try {
				// set up the file to write to
				write = this.createFeedFile();
				// point to the file location to write
				write.open(new File(this.getFullFileLocation()));
			} catch (IOException ex) {
				log.error("IO problem with write file " + getFullFileLocation()
						+ "\n" + ex.getMessage());
				return;
			}

			// set up feed file
			if (this.isUsingHeaders()) {
				// create a row in the feed file
				try {
					// get a row in the file
					DataRow headerRow = write.next();
					// write out the headers
					for (FeedColumn fC : this.getColumns()) {
						headerRow.add(fC.getHeader());
					}
				} catch (IOException ex) {
					throw new FeedException("IO problem with header "
							+ getFullFileLocation() + "\n" + ex.getMessage());

				}

			}
			// a generator produces a batch of items
			// this allows for "unions" of data done in code

			for (IFeedItemGenerator iGen : this.getGenerators()) {
				try {
					// get the items that represent the rows in the feed file
					items = iGen.getItems();
				} catch (ItemGeneratorException ex) {
					throw new FeedException("generator problem "
							+ ex.getMessage());

				}
				Iterator itemIter = items.iterator();
				DataRow currentRow = null;
				while (itemIter.hasNext()) {
					try {
						// set up a row in the file for writing
						Object item = itemIter.next();
						if (validationService.validate(item)) {
							currentRow = write.next();
							// get the POJO that represents the data for the row
							// write out the columns and map them
							for (FeedColumn fC : this.getColumns()) {

								String value = fC.getValue(item);
								// write the column value for the row
								String t = cleanValue(value);
								
								currentRow.add(t);
							}
						}
					} catch (IOException ex) {
						throw new FeedException("current row problem "
								+ ex.getMessage());

					}

				}// end while for items
			} // end for generators

		} catch (Exception err) {
			throw new FeedException("General error " + err.getClass().getName()
					+ " " + err.getMessage());
		} finally {
			if (write != null) {
				write.close();
			}
		}

	}

	/**
	 * This will clean the characters up
	 * 
	 * @param value
	 * @return
	 */
	protected String cleanValue(String input) {
		// TODO Auto-generated method stub

		if (input == null)
			return new String("");

		if (input.toUpperCase().equals("NULL")) {
			return new String("");
		}

		if (input.toUpperCase().indexOf("NULL") > -1) {
			return new String("");
		}
		String output = new String(input);
		output = stripCR(output);

		return output;
	}

	public static String stripCR(String z) {
		String ret = "";
		String t = new String(z);
		t = t.trim();

		if (t != null && t.length() > 0) {

			ret = new String(t.trim());
			ret = ret.replaceAll("\\r\\n|\\r|\\n", " ");
		}
		
		

		 
		return ret;
	}

	/**
	 * @return the delimiterCharacter
	 */
	public String getDelimiterCharacter() {
		return delimiterCharacter;
	}

	/**
	 * @param delimiterCharacter
	 *            the delimiterCharacter to set
	 */
	public void setDelimiterCharacter(String delimiterCharacter) {
		this.delimiterCharacter = delimiterCharacter;
	}

	public String getDescription() {
		
		StringBuffer info = new StringBuffer();
		for (IFeedItemGenerator g: this.getGenerators())
		{
			info.append(g.getDescription()+"\n");
		}
		return info.toString();
	}
}
