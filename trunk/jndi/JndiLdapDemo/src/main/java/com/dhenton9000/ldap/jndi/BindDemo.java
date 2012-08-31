/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.ldap.jndi;

/**
 *
 * @author dhenton
 */
import java.awt.Button;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Demonstrates how to bind a Serializable object to a directory. (Use Unbind to
 * remove binding.)
 *
 * usage: java SerObj
 */
public class BindDemo {

    private static final Logger logger = LogManager.getLogger(BindDemo.class);
    private static final String BUTTON_LOCATION =
            "cn=Button,cn=javaContainer,dc=my,dc=ldap,dc=domain";
    private static final String PROPERTIES_LOCATION =
            "cn=properties,cn=javaContainer,dc=my,dc=ldap,dc=domain";

    public static void main(String[] args) {

        // Set up environment for creating initial context
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost/");
        env.put(Context.SECURITY_PRINCIPAL, "cn=admin,dc=my,dc=ldap,dc=domain");
        env.put(Context.SECURITY_CREDENTIALS, "admin");

        try {
            // Create the initial context
            Context ctx = new InitialContext(env);
            try {
                ctx.lookup(BUTTON_LOCATION);
                ctx.unbind(BUTTON_LOCATION);
            } catch (NamingException ne) {
                //didn't find it so do nothing;
            }
             try {
                ctx.lookup(PROPERTIES_LOCATION);
                ctx.unbind(PROPERTIES_LOCATION);
            } catch (NamingException ne) {
                //didn't find it so do nothing;
            }
            // Create object to be bound
            Button b = new Button("Push me");

            // Perform bind
            ctx.bind(BUTTON_LOCATION, b);
            // Check that it is bound
            Button b2 = (Button) ctx.lookup(BUTTON_LOCATION);
            logger.debug(b2);

            Properties p = new Properties();
            p.setProperty("wisdom", "get a job");
            ctx.bind(PROPERTIES_LOCATION, p);

            Properties p2 = (Properties) ctx.lookup(PROPERTIES_LOCATION);
            logger.debug("message is "+p2.getProperty("wisdom"));

            // Close the context when we're done
            ctx.close();
        } catch (NamingException e) {
            logger.error("Operation failed: " + e);
        }
    }
}
