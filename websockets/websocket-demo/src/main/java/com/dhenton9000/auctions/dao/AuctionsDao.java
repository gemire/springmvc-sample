/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.auctions.dao;

import com.dhenton9000.auctions.model.AuctionItem;
import com.dhenton9000.auctions.model.Bidders;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author dhenton
 */
public interface AuctionsDao {

    public AuctionItem getAuctionItem(Integer auctionItemId);
    public Bidders getBidderByUserName(String name);
    public Bidders getBidderById(Integer bidderId);
    public Bidders getBiddersWithItems(Integer bidderId);
    public Integer insertBidder(Bidders b);
    public Integer insertBidForItem(@Param("auctionItemId") Integer auctionItemId, @Param("bidderId") Integer bidderId);
    public Integer insertAuctionItem(AuctionItem b);
    
}
