/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.auctions.service;

import com.dhenton9000.auctions.model.AuctionItemData;
import com.dhenton9000.auctions.model.Bidders;

/**
 *
 * @author dhenton
 */
public interface AuctionService {
    AuctionItemData getAuctionItem(Integer auctionItemId);
    public Bidders getBidderById(Integer bidderId);
    public Bidders getBidderByUserName(String username);
    public Bidders getBiddersWithItems(Integer bidderId);
    public Integer insertBidder(Bidders b);
    public Integer insertAuctionItem(AuctionItemData b);
    public Integer insertBidForItem(Integer auctionItemId, Integer bidderId);
    public void updateAuctionItem(AuctionItemData b);
    public void updateBidders(Bidders b);
    public void deleteAuctionItem(Integer id);
    public void deleteBidders(Integer id);

}
