/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.example.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.*;

/**
 *
 * @author Don
 */
public class MyXMLEOFMessageProtocolTestCase {

    private static final Logger logger = LoggerFactory.getLogger(MyXMLEOFMessageProtocolTestCase.class);
    private MyXMLEOFMessageProtocol protocol = null;

    @Before
    public void beforeTest() throws Exception {
        protocol = new MyXMLEOFMessageProtocol();

    }

    @Test
    public void testRead() throws Exception {
        final String sampleFileName = "test-samples/blockSample.xml";

        String item =  getMessage(sampleFileName);
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(sampleFileName);
        assertNotNull(is);
       
        String t = null;
        Object out = protocol.read(is);
        t = new String((byte[]) out );
        assertEquals(item,t);

    }

    private static String getMessage(String item) {
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(item);
        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(inputStream, writer, "UTF-8");
        } catch (IOException ex) {
            throw new RuntimeException("io problem with '" + item + "'");
        }
        return writer.toString();


    }
}
