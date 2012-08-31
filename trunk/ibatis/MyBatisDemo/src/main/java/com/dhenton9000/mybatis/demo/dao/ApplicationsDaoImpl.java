/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mybatis.demo.dao;

import com.dhenton9000.mybatis.demo.model.Applications;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.*;


/**
 *
 * @author dhenton
 */
public class ApplicationsDaoImpl implements ApplicationsDao {

    private Logger log = LogManager.getLogger(ApplicationsDaoImpl.class);
    
    public List  getAll() {
        return   sqlSession.selectList("getAll");
    }
    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    
    
    
}
