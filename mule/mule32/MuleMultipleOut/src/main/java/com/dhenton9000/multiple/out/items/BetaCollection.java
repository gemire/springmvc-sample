/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.multiple.out.items;

/**
 *
 * @author dhenton
 */
public class BetaCollection extends ItemListBase {
    
    public BetaCollection()
    {
        getItems().add(new Beta("manny"));
        getItems().add(new Beta("moe"));
        getItems().add(new Beta("jack"));
        getItems().add(new Beta("elmo"));
    }
    
    
}
