package com.dhenton9000.ersatzdb;

/**
 *
 */
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import com.dhenton9000.ersatzdb.generators.CustomerGenerator;
 
import com.dhenton9000.ersatzdb.vo.Customers;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.JAXBException;


public class ErsatzDBTestCase {

    private ClassPathXmlApplicationContext ctx = 
            new ClassPathXmlApplicationContext("ersatz-spring.xml");
     private static Logger log = LogManager.getLogger(ErsatzDBTestCase.class);
    
    @BeforeClass
    public static void beforeClass()
    {
        
    }
    
    @Before
    public void before()
    {
        
    }
    
    @Test
    public void testGenerator()
    {
      CustomerGenerator custGen = (CustomerGenerator)  ctx.getBean("customerGenerator");
      HashMap<String,List<Customers>> items = custGen.getItemCollection();
      assertEquals(2,items.keySet().size());
      List<Customers> c1 = null;
      c1 = items.get("allCustomers");
      assertEquals(3,c1.size());
      c1 = items.get("badCustomers");
      assertEquals(2,c1.size());
      Customers cust1 = null;
      cust1 = c1.get(1);
      assertEquals(256,cust1.getCustomerNumber());
      
    }
    
    @Test(expected=RuntimeException.class)
    public void testNullClassName()
    {
        CustomerGenerator custGen = (CustomerGenerator)  ctx.getBean("nullClassGenerator");
         HashMap<String,List<Customers>> items = custGen.getItemCollection();
    }
    
    
     @Test(expected=ErsatzException.class)
    public void testJaxbThrow()
    {
        CustomerGenerator custGen = (CustomerGenerator)  ctx.getBean("jaxbProblemGenerator");
        assertEquals("java.lang.String",custGen.getClassName());
        HashMap<String,List<Customers>> items = custGen.getItemCollection();
         
    }
    
    @Test(expected=RuntimeException.class)
    public void testBadClassThrow()
    {
        CustomerGenerator custGen = (CustomerGenerator)  ctx.getBean("badClassGenerator");
        custGen.setClassName("com.oc4j.LaughingClass");
        assertEquals("com.oc4j.LaughingClass",custGen.getClassName());
        HashMap<String,List<Customers>> items = custGen.getItemCollection();
         
    }
    
    
    @Test 
    public void createErrors()
    {
        ErsatzException ex = null;
        ex = new ErsatzException();
        Throwable t = new Throwable("ted");
        ex = new ErsatzException("fred");
        ex = new ErsatzException("fred",t);
        ex = new ErsatzException(t);
    }
    
    
    
}
