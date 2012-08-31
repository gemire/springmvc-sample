/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.multiple.out.items;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dhenton
 */
public class ItemListBase implements ItemListInterface {
    private ArrayList<ItemInterface> items = new ArrayList<ItemInterface>();
    
    @Override
    public List<ItemInterface> getItems(){ return items;}

    @Override
    public String toString() {
        String infoType = "[empty]";
        if (items.size() > 0)
        {
            infoType = items.get(0).toString();
        }
        return "ItemListBase{" + "items.size=" + items.size() 
                + " sample type= "+ infoType+ "}";
    }
}