/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.test;
import com.dhenton9000.test.mappers.XARowItem;
import com.dhenton9000.test.mappers.XATableMapper;
import java.sql.Types;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 *
 * @author Don
 * This Dao will throw a BozoException if the string 'BOZO' is in the 
 * message
 */
public class XADaoImpl implements XADao{

    private JdbcTemplate jdbcTemplate;
    private static Logger log = LogManager.getLogger(XADaoImpl.class);
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insertMessage(String message) throws Exception
    {
        String sql = "insert into xa_table (message) values (?)";
        
        
        
        Object args[] = new Object[] {message};
        int types[] = new int[] {Types.VARCHAR};
           
         jdbcTemplate.update(sql, args, types);
         
         String payload = message.toUpperCase();
         if (payload.indexOf("BOZO") > -1)
         {
             throw new BozoException("You cannot be a bozo!");
         }

            return true;
        }


    @Override
    public int getMessage(String message) throws Exception {
       String sql = "SELECT * from xa_table where message = ?";
       int key = 0;
       Object[] args = {message};
       List<XARowItem> items = jdbcTemplate.query(sql, args,  new XATableMapper());
       if (items == null || items.isEmpty())
       {
           return 0;
       }
       int latest = items.size()-1;
       key = items.get(latest).getId();
       
       return key;
       
       
    }
    
}

