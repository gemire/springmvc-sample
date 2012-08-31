/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mybatis.demo.mappers;



import com.dhenton9000.mybatis.demo.model.Applications;
import java.util.List;

/**
 *
 * @author dhenton
 */
public interface ApplicationsMapper {
    
  List<Applications>  getAllApplications();
}
