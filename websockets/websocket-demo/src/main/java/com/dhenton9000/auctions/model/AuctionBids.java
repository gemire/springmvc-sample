/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.auctions.model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author dhenton
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AuctionBids {
    private AuctionItem auctionItem;
    private ArrayList<Bidders> bidders ;

    /**
     * @return the auctionItem
     */
    public AuctionItem getAuctionItem() {
        return auctionItem;
    }

    /**
     * @param auctionItem the auctionItem to set
     */
    public void setAuctionItem(AuctionItem auctionItem) {
        this.auctionItem = auctionItem;
    }

    /**
     * @return the bidders
     */
    public ArrayList<Bidders> getBidders() {
        return bidders;
    }

    /**
     * @param bidders the bidders to set
     */
    public void setBidders(ArrayList<Bidders> bidders) {
        this.bidders = bidders;
    }
    
    
    
}
