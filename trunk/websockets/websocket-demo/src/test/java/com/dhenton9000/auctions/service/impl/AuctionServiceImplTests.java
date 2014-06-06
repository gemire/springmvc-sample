/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.auctions.service.impl;

import com.dhenton9000.auctions.model.AuctionItem;
import com.dhenton9000.auctions.model.Bidders;
import com.dhenton9000.auctions.service.AuctionService;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

/**
 *
 * @author dhenton
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext("auctions-test-context.xml")
@DataSet
public class AuctionServiceImplTests {

    @SpringBeanByType
    private AuctionService auctionService;

    private static final Logger logger = LoggerFactory.getLogger(AuctionServiceImplTests.class);

    @Test
    public void testAssemble() {
        assertNotNull(auctionService);
        AuctionItem item = auctionService.getAuctionItem(1);
        assertNotNull(item);
        assertEquals("Item 1", item.getAuctionDescription());
    }

    @Test
    public void testGetBidders() {

        Bidders b = auctionService.getBidderByUserName("user 100");
        assertNotNull(b);
        assertEquals(100, b.getId().intValue());
        
        b = auctionService.getBidderById(100);
        assertEquals(100, b.getId().intValue());
    }
    
    @Test
    public void testGetBiddersWithItems() {

        Bidders b = auctionService.getBidderByUserName("user 100");
        assertNotNull(b);
        assertEquals(100, b.getId().intValue());
        
        b = auctionService.getBiddersWithItems(200);
        assertEquals(3, b.getAuctionItems().size());
    }
    
    

}
