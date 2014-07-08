/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.chat.services;

import com.dhenton9000.chat.model.RegisteredUser;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author dhenton
 */
public class ChatUsersServiceTest {
    
    private ChatUsersService usersService = new ChatUsersServiceImpl();
    public ChatUsersServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testCache()
    {
        RegisteredUser u= usersService.get("bonzo");
        assertEquals(1,usersService.getAllUsers().size());
        assertNotNull(u);
        assertEquals("bonzo",u.getUserName());
        
    }
   
}
