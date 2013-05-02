/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.io;

import com.dhenton9000.io.UnicodeBOMInputStream.BOM;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.input.BOMInputStream;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 

/**
 * http://stackoverflow.com/questions/1835430/byte-order-mark-screws-up-file-reading-in-java/1835529#1835529
 * http://stackoverflow.com/questions/9736999/how-to-remove-bom-from-an-xml-file-in-java
 * @author dhenton
 */
public class UnicodeBOMInputStreamTest {
    private final Logger logger = LoggerFactory.getLogger(UnicodeBOMInputStreamTest.class);
    private UnicodeBOMInputStream bomIn;
    private UnicodeBOMInputStream noBomIn;
    
    
    @Before
    public void beforeTest() throws IOException
    {
       InputStream inBom =
               getClass().getClassLoader().getResourceAsStream("bom_samples/BOM_Sample.txt");
        InputStream inNoBom =
               getClass().getClassLoader().getResourceAsStream("bom_samples/no_BOM_Sample.txt");
        bomIn = new UnicodeBOMInputStream(inBom);
        noBomIn = new UnicodeBOMInputStream(inNoBom);
        assertNotNull(bomIn);
        assertNotNull(noBomIn);
    }
    
    
    @Test
    public void testInput()
    {
        BOM inVar = bomIn.getBOM();
        assertNotNull(inVar);
        assertEquals(BOM.UTF_8,inVar);
        
         BOM noInVar = noBomIn.getBOM();
        assertNotNull(noInVar);
        assertEquals(BOM.NONE,noInVar);
        
    }
    
    @After
    public void afterTest() throws IOException
    {
        bomIn.close();
        noBomIn.close();
    }
}
