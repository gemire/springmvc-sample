package com.dhenton9000.hibernatesecurity.springdao;


import com.dhenton9000.hibernatesecurity.Applications;
import com.dhenton9000.hibernatesecurity.dao.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

import java.util.List;


/**
 *
 * @author dyh
 */
public class SpringDAOTest {
  private static Logger log = LogManager.getLogger(SpringDAOTest.class);

   private static  ClassPathXmlApplicationContext ctx =
   new ClassPathXmlApplicationContext("security-spring.xml");
  private static SecuritySpringDAO sDAO = null;

  //~--- constructors ---------------------------------------------------------


  /**
   * Constructs ... TODO
   *
   */
  public SpringDAOTest() {}

  //~--- methods --------------------------------------------------------------


  /**
   * Method description TODO
   *
   *
   * @throws Exception
   */
  @BeforeClass
  public static void setUpClass()
  throws Exception {

     sDAO = (SecuritySpringDAO) ctx.getBean("springSecurityDAO");
  }


  /**
   * Method description TODO
   *
   *
   * @throws Exception
   */
  @AfterClass
  public static void tearDownClass()
  throws Exception {}


  /**
   * Method description TODO
   *
   */
  @Before
  public void setUp() {}


  /**
   * Method description TODO
   *
   */
  @After
  public void tearDown() {}


  /**
   * Method description TODO
   *
   */
  @Test
  public void testSimpleApplicationsQuery() {

     Applications a = sDAO.findApplication(new Integer(2));
     assertEquals("Colors",a.getApplicationName());
  }
}
