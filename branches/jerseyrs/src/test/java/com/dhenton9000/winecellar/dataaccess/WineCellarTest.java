/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.winecellar.dataaccess;

 
import com.dhenton9000.jersey.rs.winecellar.Wine;
import com.dhenton9000.jersey.rs.winecellar.WineDAO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.*;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author dhenton
 */
public class WineCellarTest {
     private static Logger log = LogManager.getLogger(WineCellarTest.class);
     
     private WineDAO wDAO = new WineDAO();
     
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
    public void testBasicDAO() throws Exception
    {
      Wine testItem =  wDAO.findById(2);
      assertEquals(2,testItem.getId());
     
    }
     
}
