/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mybatis.demo.mappers;

import com.dhenton9000.mybatis.demo.model.LimitParms;
import com.dhenton9000.mybatis.demo.model.Users;
import java.util.List;

/**
 *
 * @author dhenton
 */
public interface UsersMapper {
    
    Users getUser(String username);
    
    Users getUserByNested(String username);
    
    List<Users> getAllUsersWithGroupsWithNonNestedCollection(LimitParms p);
    
    List<Users> getAllUsersWithGroupsWithNestedSql(LimitParms p);
}
