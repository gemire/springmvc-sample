package com.dhenton9000.mybatis.demo;

import com.dhenton9000.mybatis.demo.mappers.GroupsMapper;
import com.dhenton9000.mybatis.demo.mappers.UsersMapper;
import com.dhenton9000.mybatis.demo.model.Groups;
import com.dhenton9000.mybatis.demo.model.LimitParms;
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
      
  
       //this uses a nested select to get the groups for a user
       UsersMapper usersMapper = (UsersMapper) context.getBean("usersMapper");
       Users george = usersMapper.getUser("gaw");
       log.debug("2 got "+george);
       log.debug("groups count is "+george.getGroups().size());
       
       
       //this uses a nested results to do the same thing
       
       Users dcj = usersMapper.getUserByNested("dcj");
//       log.debug("nested got "+dcj);
//       log.debug("groups count is "+dcj.getGroups().size());
//       String t = "\nuser: "+dcj.getUserName()+"\n";
//       for (Groups g :dcj.getGroups())
//       {
//           t += "\tGroup "+g.getGroupName()+"\n";
//       }
//       
       
      // log.debug(t);
       LimitParms p = new LimitParms();
       List<Users> users = usersMapper.getAllUsersWithGroupsWithNonNestedCollection(p);
       
       log.debug("all users "+users.size());
       log.debug("using collection\n");
       String t = printResults(users);
       log.debug(t+"\n=====================\n");
       
       users = usersMapper.getAllUsersWithGroupsWithNestedSql(p);
       log.debug("using nested\n");
       t = printResults(users);
       log.debug(t+"\n=====================\n");
       
       
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
