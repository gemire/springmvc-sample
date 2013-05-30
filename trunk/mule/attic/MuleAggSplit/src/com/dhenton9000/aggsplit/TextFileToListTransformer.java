/**
 * 
 */
package com.dhenton9000.aggsplit;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 * @author dyh
 * This transformer expects a text file with lines that are terminated
 * with '\n'
 * It places each line into an element of an ArrayList It must be used
 * with a File source so the connector must be set up to yield only 
 * a File
 * 
 */
public class TextFileToListTransformer extends AbstractTransformer {

	/**
	 * 
	 */
	public TextFileToListTransformer() {
		setReturnClass(List.class);
		registerSourceType(File.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mule.transformer.AbstractTransformer#doTransform(java.lang.Object,
	 * java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Object doTransform(Object oo, String encoding)
			throws TransformerException {
		File file = (File) oo;
		List a = null;
		try {
			a = FileUtils.readLines(file, encoding);
		} catch (IOException e) {
			throw new TransformerException(this, e);
		}

		return a;
	}

}
