package com.dhenton9000.webservice.cxf;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dhenton9000.football.generated.ArrayOftTopGoalScorer;
import com.dhenton9000.football.generated.InfoSoapType;
import com.dhenton9000.football.generated.TTopGoalScorer;

import org.apache.log4j.*;
public class FootballTest {
	
	
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("cxf-spring.xml");
    private Logger log = LogManager.getLogger(FootballTest.class);	
	
	@Test
	public void testFootBallService()
	{
		 InfoSoapType footballClient = (InfoSoapType) ctx.getBean("footballService");
		
		 ArrayOftTopGoalScorer topScorerers = footballClient.topGoalScorers(5);
		 assertEquals(5,topScorerers.getTTopGoalScorer().size());
		 String tinfo = "\n";
		 for (int i=0;i<topScorerers.getTTopGoalScorer().size();i++)
		 {
			 TTopGoalScorer t = topScorerers.getTTopGoalScorer().get(i);
			 tinfo += t.getSName()+" country "+t.getSCountry()+"\n";
			 
		 }
		 
		 log.debug(tinfo);
		 
	}
	

}
