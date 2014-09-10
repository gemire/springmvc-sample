package com.dhenton9000.jaxb.utils;
 
import java.util.ArrayList;
import static org.junit.Assert.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
 

public class MarshalTestCase {

    private static Logger log = LogManager.getLogger(MarshalTestCase.class);
     

    @BeforeClass
    public static void setUpClass() throws Exception {
    }


    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    

   
    @Before
    public void setUp() {
    }

  
    @After
    public void tearDown() {
    }

    

 

    @Test
    public void testfindGroupsMarshall() throws Exception
    {
        ArrayList<Users> users = new ArrayList<>();
        users.add(new Users("nameId","John Bonzo"));
        users.add(new Users("nameId2","John Bonzo 2"));
        users.add(new Users("nameId3","John Bonzo 3"));
        Groups k = new Groups(45,"tango",users);
         
                    
        
        String Obj2XML = MarshallUtils.Obj2XML(k);
        log.debug("\n"+Obj2XML);
        
         String Obj2JSON = MarshallUtils.Obj2JSON(k);
        log.debug("\nxxx\n"+Obj2JSON);
        
        //the jaxb.index file is in src/test/resources
        Obj2JSON = MarshallUtils.Obj2JSON("com.dhenton9000.jaxb.utils", k);
        log.debug("\nyyy\n"+Obj2JSON);
        
        
    }
   
}///////////////////////////////////////////////////////////////////////
