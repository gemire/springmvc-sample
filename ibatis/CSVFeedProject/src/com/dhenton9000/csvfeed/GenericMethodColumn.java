/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.csvfeed;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * This is a Column which will use reflection to return the
 * value from the getter associated with the propertyName on the
 * item passed in.
 * @author Don
 */
public class GenericMethodColumn extends FeedColumn {

    private String propertyName = null;
    private static Logger log = LogManager.getLogger(GenericMethodColumn.class);
    private String nullValue = "";
    
    @Override
    public String getValue(Object item) {
        String res = null;
        try {
            Class clazz = item.getClass();
            Method getter = clazz.getMethod(getMethodName(), null);
            Object tt = getter.invoke(item, null);
            if (tt != null) {
                res = tt.toString();
            } else {
                res = getNullValue();
            }
        } catch (NoSuchMethodException ex) {
            log.error("No such method " + item.getClass()+"."+getMethodName());
        } catch (SecurityException ex) {
            log.error("security problem " + item.getClass()+"."+ getMethodName());

        } catch (IllegalAccessException ex) {
            log.error("illegalAccess " + item.getClass()+"."+ getMethodName());
        } catch (InvocationTargetException ex) {
            log.error("invocationtarget " + item.getClass()+"."+ getMethodName());
        }

        return stripSpace(res);
    }

    /**
     * @return the propertyName
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * @param propertyName the propertyName to set
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /** 
     * A method to formulate a method name suitable for reflection
     * from the propertyName.
     * @return
     */
    private String getMethodName() {
        String firstLetter = getPropertyName().substring(0, 1);
        String remainingPart = getPropertyName().substring(1, getPropertyName().length());
        String methodName = "get" + firstLetter.toUpperCase() + remainingPart;
        return methodName;
    }

    /**
     * @return the  representation we want for a null. The default is
     * an empty string, can be injected by spring, so that we can custom
     * responses to a null
     */
    public String getNullValue() {
        return nullValue;
    }

    /**
     * @param nullValue the nullValue to set
     */
    public void setNullValue(String nullValue) {
        this.nullValue = nullValue;
    }
}
