/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.ersatzdb;

import java.io.StringReader;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.transform.stream.StreamSource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBException;

/**
 * This class will store collections of Value Objects that come from JAXB
 * xml. The xml is stored as Strings in the spring file, and can be derived
 * by marshaling actual items from a database.
 * 
 * The collections are keyed in a HashMap, and the HashMap, the lists
 * and this object can be wired together in Spring. Once this is done, a mock
 * DAO can use this as a source of mock results, keying off the String key
 * for various results.
 * 
 * Should the DAO methods require a single object to be returned, you can 
 * use a single member of a list to get at an object to return. Thus, you 
 * can have a List whose individual members represent the single items you 
 * wish to return for testing.
 * 
 * Because generics can't be used to get a class of the generic, you must
 * tell the this class the fully qualified className 
 * {@link #setClassName(java.lang.String) } which will be used by the 
 * unmarshalling code for JAXB
 * 
 */
public abstract class ErsatzGenerator<T> {

    private Class<T> itemClass = null;
    private Map<String, List<String>> loadedItems = null;
    private static Logger log = LogManager.getLogger(ErsatzGenerator.class);
    private HashMap<String, List<T>> itemCollection = null;
    private String className = null;

    /**
     * this constructor takes a Map keyed by an identifying string, eg
     * "allCustomers", the List is a collection of JAXB xml String representations
     * for the object, say a customer, which would be the generic T
     * @param jaxbData 
     */
    public ErsatzGenerator(Map<String, List<String>> jaxbData) {
        loadedItems = jaxbData;
    }

    /**
     * do the work of moving the xml strings into the lists and 
     * storing them under the keys
     */
    private void setupItemCollection() {
        itemCollection = new HashMap<String, List<T>>();
        for (String key : loadedItems.keySet()) {
            List<String> dataItems = loadedItems.get(key);
            List<T> newDataObjects = new ArrayList<T>();

            for (String invData : dataItems) {
                newDataObjects.add(reload(invData));

            }
            itemCollection.put(key, newDataObjects);

        }

    }

    /**
     * This method will take a Jaxb XML string and create the appropriate
     * object
     * @param xmlString
     * @return the reconstituted item Object
     */
    private T reload(String xmlString) {
        JAXBContext context;
        T reloadedItem = null;
        try {
            if (getItemClass() == null) {
                throw new RuntimeException("className must be specified in "
                        + "spring use the className property with fully qualified name");
            }
            context = JAXBContext.newInstance(getItemClass());
            StringReader sR = new StringReader(xmlString);
            reloadedItem = (T) context.createUnmarshaller().unmarshal(
                    new StreamSource(sR));
            return reloadedItem;
        } catch (JAXBException ex) {
            throw new ErsatzException(ex.getMessage() + "\n" + ex.getClass().getName() + "\n", ex);
        }

    }

    /**
     * @return the itemCollection
     */
    public HashMap<String, List<T>> getItemCollection() {

        if (itemCollection == null) {
            setupItemCollection();
        }
        return itemCollection;
    }

    public Class<T> getItemClass() {
        return itemClass;
    }

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className the className to set, also load the instance of the
     * class. Note that if this class doesn't match the class of the generic
     * you will get a bizarre error in the marshaling code
     */
    public void setClassName(String className) {
        Class itemClassSample = null;
        try {
            itemClassSample = Class.forName(className);

        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("could not find class " + className);
        }
        this.itemClass = itemClassSample;
        this.className = className;
    }
}
