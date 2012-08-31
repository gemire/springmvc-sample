package com.dhenton9000.mule30.transformers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.transformer.DataType;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.api.transformer.DataType;
import java.io.File;
import org.mule.transformer.types.DataTypeFactory;

 


public class FileToPathTransformer  extends AbstractTransformer {
	private static Logger log = LogManager.getLogger(FileToPathTransformer.class);

	
	public FileToPathTransformer()
	{
		 setReturnDataType(DataType.STRING_DATA_TYPE);
		 registerSourceType(DataTypeFactory.create(File.class));
	}
	
	
	@Override
	protected Object doTransform(Object item, String encoding)
			throws TransformerException {
		 
		File f = (File) item;
		if (f == null)
			log.error("file null");
		else
			log.info("file "+f.getAbsolutePath());
		return f.getAbsolutePath();
		 
	}

}
