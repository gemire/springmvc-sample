package com.dhenton9000.mybatis.demo;

import com.dhenton9000.mybatis.demo.mappers.GroupsMapper;
import com.dhenton9000.mybatis.demo.mappers.UsersMapper;
import com.dhenton9000.mybatis.demo.model.Groups;
import com.dhenton9000.mybatis.demo.model.Users;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.*;

/**
 * Hello world!
 *
 */
public class GroupUsersApp 
{
    private static ClassPathXmlApplicationContext context = null;
    private static Logger log = LogManager.getLogger(GroupUsersApp.class);
    public static void main( String[] args )
    {
       context = new ClassPathXmlApplicationContext("mybatis-config.xml");
   
 
       
       GroupsMapper mapper = (GroupsMapper) context.getBean("groupsMapper");
       List<Groups> groups = mapper.getAllGroups();
       log.debug("1 got "+groups.size()+" groups");
      
  
       
       UsersMapper usersMapper = (UsersMapper) context.getBean("usersMapper");
       Users george = usersMapper.getUser("gaw");
       log.debug("2 got "+george);
       log.debug("groups count is "+george.getGroups().size());
       
    }
}
