package com.dhenton9000.test;

 
import com.dhenton9000.test.mappers.ApplicationItem;
import com.dhenton9000.test.mappers.ApplicationMapper;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
 
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcComponent extends JdbcDaoSupport implements Callable {

    private static Logger log = LogManager.getLogger(JdbcComponent.class);
     

    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
        List apps = 
          this.getJdbcTemplate().query("select * from Applications", new ApplicationMapper());
                
        log.debug("##### "+apps);
        return eventContext.getMessage();
    }

    
}
