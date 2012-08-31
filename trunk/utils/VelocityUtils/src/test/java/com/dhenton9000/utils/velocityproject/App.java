package com.dhenton9000.utils.velocityproject;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * Hello world! http://velocity.apache.org/engine/devel/getting-started.html
 */
public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public void doWork() {

        VelocityEngineFactory vFactory = new VelocityEngineFactory();
        VelocityEngine ve = vFactory.getEngine();
        VelocityContext context = new VelocityContext();
        context.put("packageName","output");
        context.put("utility", new Utility());
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("fred", 35));
        items.add(new Item("joe", 27));
        logger.debug("start");
        for (Item i : items) {
            logger.debug(i);
            context.put("item",i);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/resources/output/"+Utility.proper(i.getName()) + ".java"));
                ve.mergeTemplate("templates/test.vm",  "UTF-8",context,  writer);
                writer.flush();
                writer.close();


               
            } catch (Exception err) {
                logger.error("PROBLEM "+err.getClass().getName()+"\n"+err.getMessage()+"\n",err);
            }
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.doWork();
    }
}
