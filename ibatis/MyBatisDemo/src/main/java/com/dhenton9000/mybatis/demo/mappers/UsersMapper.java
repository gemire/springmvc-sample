/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mybatis.demo.mappers;

import com.dhenton9000.mybatis.demo.model.Users;

/**
 *
 * @author dhenton
 */
public interface UsersMapper {
    
    Users getUser(String username);
}
