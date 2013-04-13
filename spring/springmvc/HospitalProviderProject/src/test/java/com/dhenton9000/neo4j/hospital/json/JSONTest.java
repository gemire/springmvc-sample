/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.hospital.json;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.http.MediaType;
import org.junit.Test;

/**
 *
 * @author dhenton
 */
public class JSONTest {

    private MappingJacksonHttpMessageConverter converter =
            new MappingJacksonHttpMessageConverter();
    private final Logger logger = LoggerFactory.getLogger(JSONTest.class);
    private String bookSample = "{\"author\":\"Fred\",\"numPages\":55}";
    
    /*
    
    {
        "author" : "Fred",
        "numPages" : 55
    }
    {"author" : "Fred","numPages" : 55}
    */

    @Test
    public void testJSONForBook() {
        boolean b = converter.canRead(TestBook.class, MediaType.APPLICATION_JSON);
        assertTrue(b);
    }

    @Test
    public void testJSONForBookTwo() throws IOException {
        TestBook testBook = new TestBook();
        testBook.setAuthor("Fred");
        testBook.setNumPages(55);
        String p = converter.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(testBook);
        logger.debug("\n\n"+p);
        String g = converter.getObjectMapper().writeValueAsString(testBook);
        assertEquals(bookSample, g);
        TestBook t2 = converter.getObjectMapper().readValue(g,TestBook.class);
        assertEquals(testBook.getAuthor(), t2.getAuthor());
        t2.toString();
    }
}
