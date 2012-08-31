/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.multiple.out;

import com.dhenton9000.multiple.out.items.ItemInterface;
import com.dhenton9000.multiple.out.items.ItemListInterface;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author dhenton
 */
public class ListToJMSMessage {
    
    private static Logger log = LogManager.getLogger(ListToJMSMessage.class);
    
    public String processList(ItemListInterface items)
    {
        String ret = "\n";
        List<ItemInterface> indivItems = items.getItems();
        
        for (ItemInterface iF : indivItems)
        {
            ret += iF.getMessage()+"\n";
        }
        
        return ret;
    }
}
