/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.auctions.model;

import java.util.Objects;

/**
 *
 * @author dhenton
 */
public class AuctionItem {
    
    private Integer id;
    private String auctionDescription;
    private Float startingBid;

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
     * @return the auctionDescription
     */
    public String getAuctionDescription() {
        return auctionDescription;
    }

    /**
     * @param auctionDescription the auctionDescription to set
     */
    public void setAuctionDescription(String auctionDescription) {
        this.auctionDescription = auctionDescription;
    }

    /**
     * @return the startingBid
     */
    public Float getStartingBid() {
        return startingBid;
    }

    /**
     * @param startingBid the startingBid to set
     */
    public void setStartingBid(Float startingBid) {
        this.startingBid = startingBid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final AuctionItem other = (AuctionItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AuctionItem{" + "id=" + id + ", auctionDescription=" + auctionDescription + ", startingBid=" + startingBid + '}';
    }
    
    
    
    
    
}
