/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mybatis.demo.dao;

import com.dhenton9000.mybatis.demo.model.Applications;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.*;
import org.mybatis.spring.support.SqlSessionDaoSupport;


/**
 *
 * @author dhenton
 */
public class ApplicationsSupportDaoImpl extends SqlSessionDaoSupport implements ApplicationsDao {

    private Logger log = LogManager.getLogger(ApplicationsSupportDaoImpl.class);
    
    public List  getAll() {
        return   this.getSqlSession().selectList("getAll");
    }
     
    
    
    
}
