/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.collection.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

 

import java.util.ArrayList;
import org.apache.commons.io.LineIterator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

//http://docs.oracle.com/cd/E17802_01/webservices/webservices/docs/2.0/tutorial/doc/StAX6.html#wp106579
//http://www.ibm.com/developerworks/library/x-stax2/index.html


public class CollectionCreator implements Callable {

    private final static Logger log = LogManager.getLogger(CollectionCreator.class);

    /**
     * take a simple text file and split the lines into an array
     * @param eventContext
     * @return
     * @throws Exception 
     */
    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
        File filePayload = null;
        Object payload = eventContext.getMessage().getPayload();
        log.info("Payload is " + payload.getClass().getName());
        if (payload instanceof File) {
            filePayload = (File) payload;
        } else {
            throw new RuntimeException("payload should be File but was "
                    + payload.getClass().getName());
        }
        log.info("file Location " + filePayload.getCanonicalPath());
        
        ArrayList<String> listItems = new ArrayList<String>();
        LineIterator lineIterator = FileUtils.lineIterator(filePayload, "UTF-8");
        
        while (lineIterator.hasNext())
        {
                 
            String lineContents = lineIterator.nextLine();
            listItems.add(lineContents);
            
            
        }

        return listItems;
    }

    
     
}