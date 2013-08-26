/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mybatis.demo.mappers;

import com.dhenton9000.mybatis.demo.GroupUsersApp;
import com.dhenton9000.mybatis.demo.model.LimitParms;
import com.dhenton9000.mybatis.demo.model.Users;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class demonstrates the interaction and use of limits on one to many
 * relationships. Given a parent child relationship, if you want 10 rows of parents
 * regardless of the number of children, then you have to use nested sqls
 * to get the children or a ResultHandlerExample overrides, for the latter see:
 * 
 * https://code.google.com/p/mybatis/wiki/ResultHandlerExample
 * http://stackoverflow.com/questions/11798479/mybatis-mapping-multiple-columns-to-an-array
 * 
 * @author dhenton
 */
public class MapperNestedTests {
    
    private static ClassPathXmlApplicationContext  context = null;
    private static Logger log = LogManager.getLogger(MapperNestedTests.class);
    private static UsersMapper usersMapper = null;
 
    
    
    @BeforeClass
    public static void beforeEverything()
    {
        context = new ClassPathXmlApplicationContext("mybatis-config.xml");
        usersMapper = (UsersMapper) context.getBean("usersMapper");
    }
     
    
    @Test
    public void testLimitEffectOnCollection()
    {
       LimitParms p = new LimitParms();// default is 0 offset 10 limit
       List<Users> users = usersMapper.getAllUsersWithGroupsWithNonNestedCollection(p);
       
       log.debug("all users "+users.size());
       log.debug("using collection\n");
       String t = printResults(users);
       log.debug(t+"\n=====================\n");
       int result = 0;
       for (Users u:users)
       {
           result += u.getGroups().size();
       }
       
       assertEquals(p.getLimit(),result);

    }
    
    
    @Test
    public void testLimitEffectOnNested()
    {
       LimitParms p = new LimitParms();// default is 0 offset 10 limit
       List<Users> users = usersMapper.getAllUsersWithGroupsWithNestedSql(p);
       
       log.debug("all users "+users.size());
       log.debug("using collection\n");
       String t = printResults(users);
       log.debug(t+"\n=====================\n");
        
       assertEquals(p.getLimit(),users.size());

    }
    
    
    
    private static String printResults(List<Users> users)
    {
        String t = "";
       t="\n#\tUsername\tGroup Count\n";
       int i = 0;
       for (Users u: users)
       {
           i++;
           t += i+"\t"+u.getUserId()+"\t\t"+u.getGroups().size()+"\n";
       }
       return t;
    }
    
    
}
