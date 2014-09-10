/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.jaxb.utils;
 

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;
import com.sun.jersey.api.json.JSONMarshaller;
import com.sun.jersey.api.json.JSONUnmarshaller;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamSource;

/**
 *
 */
public class MarshallUtils {

    /**
     * generates xml string from a appropriately marked jaxb object
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
     *  JAXBContext context = 
     *   JAXBContext.newInstance(k.getClass(),
     *   GroupAssignments.class, alpha.class ...);
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
    
    public static Object JSON2Obj(String contextPath,String jsonString, Class targetClass) throws JAXBException
    {
        Map props = new HashMap<>();
        JSONJAXBContext context   = new JSONJAXBContext(contextPath);
        JSONUnmarshaller m = context.createJSONUnmarshaller();
        StringReader sReader = new StringReader(jsonString);
        Object r = m.unmarshalFromJSON(sReader, targetClass);
        return r;
    }
    
    
  /**
     * generates xml string from a appropriately marked jaxb object
     * @param ob the object to convert
     * @return the xml string instance
     * @throws JAXBException 
     */
    public static String Obj2JSON(Object ob) throws JAXBException {
        String info = null;

        Map props = new HashMap<>();
       // props.put(JSONJAXBContext.JSON_NOTATION, JSONJAXBContext.JSONNotation.MAPPED);
       // props.put(JSONJAXBContext.JSON_ROOT_UNWRAPPING, Boolean.TRUE);
       // props.put(JSONJAXBContext.JSON_ARRAYS, jsonArray);
       
       // this.types = new HashSet<Class<?>>(Arrays.asList(classTypes));
        Class [] classTypes = {ob.getClass()};
        JSONJAXBContext context   = new JSONJAXBContext(classTypes, props);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        JSONMarshaller m = context.createJSONMarshaller();
        m.setProperty("jaxb.formatted.output", true);
        m.marshallToJSON(ob, baos);

        try {
            info = baos.toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new JAXBException("Encoding problem " + e.getMessage());
        }
        return info;

    }
    /**
     * this requires a jaxb.index file in the contextPath, which is a collection
     * of simple class names. The file resides in the same folder as the annotated
     * classes see com/dhenton9000/jaxb/utils/jaxb.index
     * 
     * the individual class names
     * @param contextPath
     * @param ob
     * @return
     * @throws JAXBException 
     */
    public static String Obj2JSON(String contextPath, Object ob) throws JAXBException {
       
        String info = null;
        JSONJAXBContext jContext = new JSONJAXBContext(contextPath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        JSONMarshaller m = jContext.createJSONMarshaller();
        m.setProperty("jaxb.formatted.output", true);
        m.marshallToJSON(ob, baos);
 
        try {
            info = baos.toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new JAXBException("Encoding problem " + e.getMessage());
        }
        return info;
        
    }
    //http://blogs.oracle.com/japod/entry/better_json_available_in_jersey
    
       public static String Obj2JSONUnwrap(String contextPath, Object ob) throws JAXBException {
       
        String info = null;
         
        JSONConfiguration j = JSONConfiguration.mapped().attributeAsElement("type").rootUnwrapping(false).build();
        JSONJAXBContext jContext = new JSONJAXBContext(j,contextPath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        JSONMarshaller m = jContext.createJSONMarshaller();
        m.marshallToJSON(ob, baos);
 
        try {
            info = baos.toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new JAXBException("Encoding problem " + e.getMessage());
        }
        return info;
        
    }
    
}


/*
 Map<String, Object> props = new HashMap<String, Object>();
            props.put(JSONJAXBContext.JSON_NOTATION, "MAPPED_JETTISON");
            props.put(JSONJAXBContext.JSON_ROOT_UNWRAPPING, Boolean.FALSE);

 */