package com.dhenton9000.example.tcp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Echo
{
    
      private static final Logger logger = LoggerFactory.getLogger(Echo.class);

    
    
    /* Methods */
    public DataObject echoMessage(DataObject data) {
        System.out.println("data.getId() = " + data.getId());
        data.setId(data.getId()+1);
        return data;
    }
    
    
    public String echoString(String t)
    {
        logger.debug("@@@ Echo UMO "+t);
        return t;
    }

}
