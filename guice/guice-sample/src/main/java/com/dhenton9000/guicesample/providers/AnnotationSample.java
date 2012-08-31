/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.providers;

import com.dhenton9000.guicesample.annotations.PropertyAnnotation;
import com.google.inject.Inject;

/**
 *
 * @author dhenton
 */
public class AnnotationSample {

    @Inject
    @PropertyAnnotation("BOOLEAN")
    private boolean booleanTest = false;
    @Inject
    @PropertyAnnotation("STRING")
    private String testString = null;
    private int integerTest = 99;
    private int otherIntegerTest = 55;
    

    /**
     * @return the booleanTest
     */
    public boolean isBooleanTest() {
        return booleanTest;
    }

    /**
     * @param booleanTest the booleanTest to set
     */
    public void setBooleanTest(boolean booleanTest) {
        this.booleanTest = booleanTest;
    }

    /**
     * @return the integerTest
     */
    public int getIntegerTest() {
        return integerTest;
    }

    /**
     * @param integerTest the integerTest to set
     */
     @Inject
    
    public void setIntegerTest(@PropertyAnnotation("INTEGER") int integerTest) {
        this.integerTest = integerTest;
    }

    /**
     * @return the otherIntegerTest
     */
    public int getOtherIntegerTest() {
        return otherIntegerTest;
    }

    /**
     * @param otherIntegerTest the otherIntegerTest to set
     */
    public void setOtherIntegerTest(int otherIntegerTest) {
        this.otherIntegerTest = otherIntegerTest;
    }

    /**
     * @return the testString
     */
    public String getTestString() {
        return testString;
    }

    /**
     * @param testString the testString to set
     */
    public void setTestString(String testString) {
        this.testString = testString;
    }
}
