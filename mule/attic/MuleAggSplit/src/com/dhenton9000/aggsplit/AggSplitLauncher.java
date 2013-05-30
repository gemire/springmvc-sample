package com.dhenton9000.aggsplit;

 
import org.apache.commons.logging.*;
import org.mule.api.MuleContext;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;



public class AggSplitLauncher {

	private static Log log = LogFactory.getLog(AggSplitLauncher.class);

	public AggSplitLauncher() {
	}

	public static void main(String[] args) {

		log.debug("starting launcher");

		DefaultMuleContextFactory muleContextFactory = new DefaultMuleContextFactory();
		try {
			
			SpringXmlConfigurationBuilder configBuilder = new SpringXmlConfigurationBuilder(
			"aggsplit-config.xml");

			MuleContext context = muleContextFactory.createMuleContext(configBuilder);
			context.start();
			
			log.debug("finished");

		} catch (Exception e) {
			String eInfo = "Error Class: " + e.getClass().getName() + "\n"
					+ "message: " + e.getMessage();
			log.error(eInfo);
		}

	}

}
