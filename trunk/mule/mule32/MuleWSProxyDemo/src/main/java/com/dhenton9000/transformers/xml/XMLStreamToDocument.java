/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.transformers.xml;

import javax.xml.stream.XMLStreamReader;
import org.codehaus.staxmate.dom.DOMConverter;
import org.mule.api.transformer.DataType;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;
import org.w3c.dom.Document;

/**
 * This transformer will take a XMLStream and turn it into a DOM document
 * using the Converter from staxmate
 * @author dhenton
 */
public class XMLStreamToDocument extends AbstractTransformer {

    public XMLStreamToDocument()
    {
        
        DataType<XMLStreamReader> rType = DataTypeFactory.create(XMLStreamReader.class);
        this.registerSourceType(rType);
        
        this.returnType = DataTypeFactory.create(org.w3c.dom.Document.class);
    }
    
    
    
    @Override
    protected Object doTransform(Object vS, String string) throws TransformerException {
        DOMConverter d = new DOMConverter();
        Document doc = null;
        try 
        {
            doc = d.buildDocument((XMLStreamReader) vS);
        }
        catch(Exception err)
        {
            throw new TransformerException(this,err);
        }
        return doc;
    }
    
}
