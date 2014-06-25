/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.auctions.service.impl;

import com.dhenton9000.auctions.dao.AuctionsDao;
import com.dhenton9000.auctions.model.AuctionItem;
import com.dhenton9000.auctions.model.Bidders;
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

    @Override
    public Bidders getBidderByUserName(String userName) {
        return getAuctionsDao().getBidderByUserName(userName);
    }

    @Override
    public Bidders getBidderById(Integer id) {
        return getAuctionsDao().getBidderById(id);
    }

    @Override
    public Bidders getBiddersWithItems(Integer id) {
        return getAuctionsDao().getBiddersWithItems(id);
    }

    /**
     *
     * @param b
     * @return the key
     */
    @Override
    public Integer insertBidder(Bidders b) {
        return getAuctionsDao().insertBidder(b);
    }

    @Override
    public Integer insertAuctionItem(AuctionItem b) {
        return getAuctionsDao().insertAuctionItem(b);
    }

    @Override
    public Integer insertBidForItem(Integer auctionItemId, Integer bidderId) {
        return getAuctionsDao().insertBidForItem(auctionItemId, bidderId);
    }

    @Override
    public void updateAuctionItem(AuctionItem b) {
        getAuctionsDao().updateAuctionItem(b);
    }

    @Override
    public void updateBidders(Bidders b) {
        getAuctionsDao().updateBidders(b);
    }

    @Override
    public void deleteAuctionItem(Integer id) {
        getAuctionsDao().deleteAuctionItem(id);
    }

    @Override
    public void deleteBidders(Integer id) {
        getAuctionsDao().deleteBidders(id);
    }
}
