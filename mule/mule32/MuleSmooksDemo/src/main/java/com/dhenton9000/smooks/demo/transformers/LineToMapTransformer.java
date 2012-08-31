/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.smooks.demo.transformers;

 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.CoreMessages;
import org.mule.transformer.AbstractTransformer;

public class LineToMapTransformer extends AbstractTransformer
{

    @Override
    protected Object doTransform(Object src, String encoding) throws TransformerException
    {
		try
		{
			InputStream input = (InputStream) src;
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			List<Map<String, String>> retValue = new ArrayList<Map<String,String>>();
			String line = null;
			while ((line = reader.readLine()) != null)
			{
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				
				Map<String, String> row = new HashMap<String, String>();
                                //TODO: have this class hold the column names 
                                //ie the map of the csv file
                                
                                //have a mule step strip the first line of the file
                                //if it contains column headers
                                for (int i=0;i<4;i++ )
                                {
                                  row.put("columnName"+i, tokenizer.nextToken());
                                }
				//row.put("name", tokenizer.nextToken());
				//row.put("country", tokenizer.nextToken());
				retValue.add(row);
			}
			
			input.close();
			
			return retValue;
		}
		catch (IOException iox)
		{
			throw new TransformerException(CoreMessages.transformFailed("File", "Line to Map"), iox);
		}
    }

}