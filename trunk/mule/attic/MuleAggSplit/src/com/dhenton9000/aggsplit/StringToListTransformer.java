/**
 * 
 */
package com.dhenton9000.aggsplit;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 * @author dyh This transformer expects a String and splits it on lines
 *         terminated with '\n' It places each line into an element of an
 *         ArrayList It may have problems with VERY large files
 * 
 */
public class StringToListTransformer extends AbstractTransformer {

	/**
	 * 
	 */
	public StringToListTransformer() {
		setReturnClass(List.class);
		registerSourceType(java.lang.String.class);
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
		String s = (String) oo;
		String[] items = s.split("\\n");
		ArrayList a = new ArrayList();
		for (String x:items)
		{
			a.add(x);
		}
		return a;
	}

}
