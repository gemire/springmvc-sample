/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jaxb.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamSource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
 
/**
 *
 */
public class MarshallUtils {

    private static final Logger LOG = LogManager.getLogger(MarshallUtils.class);
    /**
     * generates xml string from a appropriately marked jaxb object
     *
     * @param ob the object to convert
     * @return the xml string instance
     * @throws JAXBException
     */
    public static String Obj2XML(Object ob) throws JAXBException {
        String info = null;

        JAXBContext context = JAXBContext.newInstance(ob.getClass());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Marshaller m = context.createMarshaller();
        m.setProperty("jaxb.formatted.output", true);
        m.marshal(ob, baos);

        try {
            info = baos.toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new JAXBException("Encoding problem " + e.getMessage());
        }
        return info;

    }

    /**
     * if your object contains collections of other objects, this marshaller
     * needs to know about them. this is done via a passed in context
     * JAXBContext context = JAXBContext.newInstance(k.getClass(),
     * GroupAssignments.class, alpha.class ...);
     *
     * At least the class of the original object (k above) must be included
     *
     * @param context Jaxb context
     * @param ob to translate to xml
     * @return XML representation
     * @throws JAXBException
     */
    public static String Obj2XML(JAXBContext context, Object ob) throws JAXBException {
        String info = null;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Marshaller m = context.createMarshaller();
        m.setProperty("jaxb.formatted.output", true);
        m.marshal(ob, baos);

        try {
            info = baos.toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new JAXBException("Encoding problem " + e.getMessage());
        }
        return info;

    }

    /**
     * Takes an XML string and turns it into an instance of the target class
     *
     * @param xml the xml string representation
     * @param targetClass the target class that the xml represents
     * @return the unmarshalled object it should be of class targetClass
     * @throws JAXBException
     */
    public static Object XML2Obj(String xml, Class targetClass) throws JAXBException {
        Object o = null;
        JAXBContext context = JAXBContext.newInstance(targetClass);

        StringReader sR = new StringReader(xml);

        o = context.createUnmarshaller().unmarshal(
                new StreamSource(sR));
        return o;
    }

    /**
     * generates xml string from a appropriately marked jaxb object
     *
     * @param ob the object to convert
     * @return the xml string instance
     * @throws JAXBException
     * @throws java.io.IOException
     */
    public static String Obj2JSON(Object ob) throws JAXBException, IOException {
         
        ObjectMapper mapper = new ObjectMapper();
        Writer w = new StringWriter();
        mapper.writeValue(w, ob);
        return w.toString();

    }

    /**
     * 
     * @param <T>
     * @param jsonString
     * @param destinationType
     * @return
     * @throws IOException 
     */
    public static <T> T JSON2Obj(String jsonString,Class<T> destinationType) 
            throws IOException
    {
         ObjectMapper mapper = new ObjectMapper();
         return mapper.readValue(jsonString, destinationType);
    }

}


 