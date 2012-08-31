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
public class ApplicationMapper<Application> implements RowMapper {
    
 

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
            ApplicationItem a = new ApplicationItem();
            a.setApplicationName(rs.getString("application_name"));
            a.setId(rs.getInt("id"));
		 return a;
	}

 
}