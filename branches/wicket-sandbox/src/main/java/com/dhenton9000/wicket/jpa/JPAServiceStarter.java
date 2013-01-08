/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.jpa;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

/**
 *
 * @author dhenton
 */
 



public class JPAServiceStarter {
 @Inject 
        JPAServiceStarter(PersistService service) {
  service.start();
   
 }
}