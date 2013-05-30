/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.hospital.json;

/**
 *
 * @author dhenton
 */
public class TestBook {
    private String author = null;
    private int numPages = 0;

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the numPages
     */
    public int getNumPages() {
        return numPages;
    }

    /**
     * @param numPages the numPages to set
     */
    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    @Override
    public String toString() {
        return "TestBook{" + "author=" + author + ", numPages=" + numPages + '}';
    }
    
}
