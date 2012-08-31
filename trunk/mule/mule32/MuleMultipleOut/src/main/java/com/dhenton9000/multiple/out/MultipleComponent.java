/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.multiple.out;

 
import com.dhenton9000.multiple.out.items.AlphaCollection;
import com.dhenton9000.multiple.out.items.BetaCollection;
import com.dhenton9000.multiple.out.items.ItemListInterface;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;


/**
 * This class will produce a list of multiple objects of different types,
 * with the same interface, the splitter will pass each element on. A choice
 * router will route each item to a destination.
 * @author dhenton
 */
public class MultipleComponent implements Callable {
private static Logger log = LogManager.getLogger(MultipleComponent.class);
    @Override
    public Object onCall(MuleEventContext mec) throws Exception {
        
        List itemsToReturn = new  ArrayList<ItemListInterface>();
        itemsToReturn.add(new AlphaCollection());
        itemsToReturn.add(new BetaCollection());
        
        return itemsToReturn;
    }
    
}
