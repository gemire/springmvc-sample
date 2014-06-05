/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.auctions.service.impl;

import com.dhenton9000.auctions.dao.AuctionsDao;
import com.dhenton9000.auctions.model.AuctionItem;
import com.dhenton9000.auctions.service.AuctionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class AuctionServiceImpl implements AuctionService {

    private static final Logger logger = LoggerFactory.getLogger(AuctionServiceImpl.class);

    private AuctionsDao auctionsDao;

    /**
     * @return the auctionsDao
     */
    public AuctionsDao getAuctionsDao() {
        return auctionsDao;
    }

    /**
     * @param auctionsDao the auctionsDao to set
     */
    public void setAuctionsDao(AuctionsDao auctionsDao) {
        this.auctionsDao = auctionsDao;
    }

    @Override
    public AuctionItem getAuctionItem(Integer auctionItemId) {
       return getAuctionsDao().getAuctionItem(auctionItemId);
    }

}
