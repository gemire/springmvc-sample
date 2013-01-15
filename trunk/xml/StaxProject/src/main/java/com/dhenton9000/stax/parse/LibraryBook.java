/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.stax.parse;

/**
 *
 * @author dhenton
 */
public class LibraryBook {
    
    private String libraryName = null;
    private String title = null;
    private String author = null;
    private Float cost = null;
    private String currency = null;
    private String ISBN = null;

    /**
     * @return the libraryName
     */
    public String getLibraryName() {
        return libraryName;
    }

    /**
     * @param libraryName the libraryName to set
     */
    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

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
     * @return the cost
     */
    public Float getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(Float cost) {
        this.cost = cost;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return the ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "LibraryBook{" + "libraryName=" + libraryName + ", title=" 
                + title + ", author=" + author + ", cost=" + cost 
                + ", currency=" + currency + ", ISBN=" + ISBN + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.ISBN != null ? this.ISBN.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LibraryBook other = (LibraryBook) obj;
        if ((this.ISBN == null) ? (other.ISBN != null) : !this.ISBN.equals(other.ISBN)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
    
}
