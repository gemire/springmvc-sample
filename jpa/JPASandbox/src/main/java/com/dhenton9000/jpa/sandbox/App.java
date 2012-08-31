package com.dhenton9000.jpa.sandbox;

import com.dhenton9000.jpa.sandbox.generated.UsersJpaController;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.slf4j.*;

/**
 * Hello world!
 *
 */
public class App {
public static Logger log = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        App app = new App();
        app.basicJPA();
    }

    private  void basicJPA() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("SecurityPersistence");
        EntityManager em = emf.createEntityManager();

        UsersJpaController userController = new UsersJpaController(emf);
        log.info("user count "+userController.getUsersCount());
    }
}
