/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.multiple.out.items;

/**
 *
 * @author dhenton
 */
public class AlphaCollection extends ItemListBase {
    
    public AlphaCollection()
    {
        getItems().add(new Alpha("fred"));
        getItems().add(new Alpha("ted"));
        getItems().add(new Alpha("ned"));
        getItems().add(new Alpha("zed"));
    }
    
    
}
