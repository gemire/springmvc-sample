/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.test.mappers;

/**
 *
 * @author dhenton
 */
public class XARowItem {
    private int id = 0;
    private String message = null;
    private java.sql.Date insertTime = null;

    public XARowItem()
    {
        
    }
    @Override
    public String toString() {
        return "Row{" + "id=" + id + ", message='" + getMessage() +",time="+getInsertTime()+ "'}";
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }


    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the insertTime
     */
    public java.sql.Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime the insertTime to set
     */
    public void setInsertTime(java.sql.Date insertTime) {
        this.insertTime = insertTime;
    }


}
