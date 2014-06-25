/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.auctions.dao;

import com.dhenton9000.auctions.model.AuctionItemData;
import com.dhenton9000.auctions.model.Bidders;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author dhenton
 */
public interface AuctionsDao {

    public AuctionItemData getAuctionItem(Integer auctionItemId);
    public Bidders getBidderByUserName(String name);
    public Bidders getBidderById(Integer bidderId);
    public Bidders getBiddersWithItems(Integer bidderId);
    public Integer insertBidder(Bidders b);
    public Integer insertBidForItem(@Param("auctionItemId") Integer auctionItemId, @Param("bidderId") Integer bidderId);
    public Integer insertAuctionItem(AuctionItemData b);
    public void updateAuctionItem(AuctionItemData b);
    public void updateBidders(Bidders b);
    public void deleteAuctionItem(@Param("id") Integer id);
    public void deleteBidders(@Param("id") Integer id);
}
