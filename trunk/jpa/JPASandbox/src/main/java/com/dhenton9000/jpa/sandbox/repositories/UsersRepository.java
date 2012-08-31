/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.sandbox.repositories;

import com.dhenton9000.jpa.sandbox.generated.Users;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Don
 */
public interface UsersRepository extends CrudRepository<Users, String>, JpaSpecificationExecutor<Users>{
    
}
