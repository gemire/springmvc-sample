/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jdbc.test.transformers;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author dhenton
 */
public class DBMapToText {
    
    public String processMap(Map item)
    {
        String info = "";
        Set keys = item.keySet();
        Iterator iter = keys.iterator();
        while (iter.hasNext())
        {
            String k =(String) iter.next();
            info += "Key: "+k+"-->"+item.get(k)+"\n";
         }
        
       // throw new RuntimeException("bite me");
       return info;
    }
}
