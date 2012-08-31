package com.dhenton9000.mybatis.demo;

import com.dhenton9000.mybatis.demo.dao.ApplicationsDao;
import com.dhenton9000.mybatis.demo.mappers.ApplicationsMapper;
import com.dhenton9000.mybatis.demo.model.Applications;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.*;

/**
 * Hello world!
 *
 */
public class App 
{
    private static ClassPathXmlApplicationContext context = null;
    private static Logger log = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
       context = new ClassPathXmlApplicationContext("mybatis-config.xml");
   
       // using simple session injection
       ApplicationsDao dao = (ApplicationsDao) context.getBean("applicationsDao");
       List<Applications> apps = dao.getAll();
       log.debug("1 got "+apps.size()+" apps");
       
       
       // using daoSupport
       dao = (ApplicationsDao) context.getBean("applicationsDaoSupport");
       apps = dao.getAll();
       log.debug("2 got "+apps.size()+" apps");
       
       
       // using the proxying MapperFactoryBean
       
       ApplicationsMapper mapper = (ApplicationsMapper) context.getBean("applicationsMapper");
       apps = mapper.getAllApplications();
       log.debug("3 got "+apps.size()+" apps");
      
  
       
    }
}
