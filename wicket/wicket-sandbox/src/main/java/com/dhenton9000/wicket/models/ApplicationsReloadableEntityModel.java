/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.models;

import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.wicket.models.ReloadableEntityModel;


/**
 *
 * @author dhenton
 */
public class ApplicationsReloadableEntityModel
        extends ReloadableEntityModel<Applications, Integer> {

    public ApplicationsReloadableEntityModel(Applications entity) {
        super(entity);
    }
    
    
}
