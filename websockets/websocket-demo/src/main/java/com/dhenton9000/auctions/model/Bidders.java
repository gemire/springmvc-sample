/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.auctions.model;

import java.util.ArrayList;

/**
 *
 * @author dhenton
 */
public class Bidders {
    
    private Integer id;
    private String userName;
    private ArrayList<AuctionItem> auctionItems;
    private String password;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the auctionItems
     */
    public ArrayList<AuctionItem> getAuctionItems() {
        return auctionItems;
    }

    /**
     * @param auctionItems the auctionItems to set
     */
    public void setAuctionItems(ArrayList<AuctionItem> auctionItems) {
        this.auctionItems = auctionItems;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
