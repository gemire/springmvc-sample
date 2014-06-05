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
public class BiddersItems {
    private Bidders bidder;
    private ArrayList<AuctionItem> items;

    /**
     * @return the bidder
     */
    public Bidders getBidder() {
        return bidder;
    }

    /**
     * @param bidder the bidder to set
     */
    public void setBidder(Bidders bidder) {
        this.bidder = bidder;
    }

    /**
     * @return the items
     */
    public ArrayList<AuctionItem> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(ArrayList<AuctionItem> items) {
        this.items = items;
    }
}
