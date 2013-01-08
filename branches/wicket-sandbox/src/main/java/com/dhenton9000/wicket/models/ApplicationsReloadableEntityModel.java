/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.models;

 
import com.dhenton9000.jpa.entities.Applications;
 


/**
 *
 * @author dhenton
 */
public class ApplicationsReloadableEntityModel
        extends HibernateReloadableEntityModel<Applications, Integer> {

    public ApplicationsReloadableEntityModel(Applications entity) {
        super(entity);
    }

   
    
    
}
