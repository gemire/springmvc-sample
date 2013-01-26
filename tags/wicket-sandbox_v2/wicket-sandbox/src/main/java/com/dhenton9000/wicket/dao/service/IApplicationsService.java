/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.dao.service;

import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.jpa.entities.Users;
import com.dhenton9000.jpa.service.support.GenericEntityService;
import java.util.List;

/**
 *
 * @author dhenton
 */
public interface IApplicationsService extends GenericEntityService<Applications,Integer> {
   
    
    List<Applications> getAllApplications();
    List<Users> findUsersForApplications(Applications selectedApplication);
    
}
