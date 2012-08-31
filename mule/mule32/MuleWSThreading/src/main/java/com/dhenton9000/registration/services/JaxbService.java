/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration.services;

 

import com.dhenton9000.registration.bindings.RegisterInput;
import com.dhenton9000.registration.bindings.RegisterResponse;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;

 
 

/**
 * Base class for all components provides JAXB functionality
 * 
 * @author dhenton
 * 
 */
public class JaxbService   {

	private JAXBContext jaxbContext;

	/**
	 * Translate a JAXB annotated object to a String xml representation
	 * 
	 * @param o object to translate
	 * @return String with xml
	 * @throws JAXBException
	 * @throws UnsupportedEncodingException
	 */
 
	public String jaxbToString(Object o) throws JAXBException, UnsupportedEncodingException {

		String info = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		getJaxbContext().createMarshaller().marshal(o, baos);
		info = baos.toString("UTF-8");
		return info;
	}

	 
	public RegisterInput jaxBStringToRegisterInput(String xml) throws JAXBException, UnsupportedEncodingException {

		StringReader sR = new StringReader(xml);
		RegisterInput o = null;
		o = (RegisterInput) getJaxbContext().createUnmarshaller().unmarshal(new StreamSource(sR));
		return o;

	}

	
	public RegisterResponse jaxBStringToRegisterResponse(String xml) throws JAXBException, UnsupportedEncodingException {
		StringReader sR = new StringReader(xml);
		RegisterResponse o = null;
		o = (RegisterResponse) getJaxbContext().createUnmarshaller().unmarshal(new StreamSource(sR));
		return o;

	}

    /**
     * @return the jaxbContext
     */
    public JAXBContext getJaxbContext() {
        return jaxbContext;
    }

    /**
     * @param jaxbContext the jaxbContext to set
     */
    public void setJaxbContext(JAXBContext jaxbContext) {
        this.jaxbContext = jaxbContext;
    }

}
