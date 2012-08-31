/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.test.mappers;

 
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author dhenton
 */
public class XATableMapper<XATableMapper> implements RowMapper {
    
 

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
            XARowItem a = new XARowItem();
            a.setMessage(rs.getString("MESSAGE"));
            a.setId(rs.getInt("ID"));
            a.setInsertTime(rs.getDate("INSERT_TIME"));
	    return a;
	}

 
}