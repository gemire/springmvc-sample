package com.dhenton9000.ldap.jndi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import javax.naming.Context;
import javax.naming.NameAlreadyBoundException;
import javax.naming.directory.*;
import java.util.*;

/**
 * This creates a javaContainer, this is a subcontext on the ldap
 * server that because it came from java is called a javaContainer
 *
 */
public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        logger.debug("Hello World!");
        String rootContext = null;
        Properties env = new Properties();

        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost/");
        env.put(Context.SECURITY_PRINCIPAL, "cn=admin,dc=my,dc=ldap,dc=domain");
        env.put(Context.SECURITY_CREDENTIALS, "admin");

        try {
            // obtain initial directory context using the environment
            DirContext ctx = new InitialDirContext(env);

            // now, create the root context, which is just a subcontext
            // of this initial directory context.
            rootContext = "cn=javaContainer,dc=my,dc=ldap,dc=domain";
            ctx.createSubcontext(rootContext);
        } catch (NameAlreadyBoundException nabe) {
            logger.error(rootContext + " has already been bound!");
        } catch (Exception e) {
            logger.error("general error ", e);
        }
    }
}
