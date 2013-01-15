
package com.dhenton9000.file.transformers;

import org.mule.api.MuleContext;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 *
 * @author dhenton
 *
 */
public class Launcher {

    private static final Logger logger = LoggerFactory.getLogger(Launcher.class);

    public static MuleContext doLaunch() {
        DefaultMuleContextFactory muleContextFactory = new DefaultMuleContextFactory();
        MuleContext context = null;
        logger.debug("start");
        try {

            String[] configFiles = {
                "mule-file-transformer.xml"
            };
            SpringXmlConfigurationBuilder configBuilder = new SpringXmlConfigurationBuilder(configFiles);
            context = muleContextFactory.createMuleContext(configBuilder);
            context.start();

        } catch (Exception e) {
            String eInfo = "Error Class: " + e.getClass().getName() + "\n" + "message: " + e.getMessage();
            logger.error(eInfo);
        }
        logger.debug("end");
        return context;

    }

    public static void main(String[] args) {

        Launcher.doLaunch();
    }
}
