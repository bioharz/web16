package fh.kufstein.Utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by 1510653032 on 25.04.2017.
 */
public class DBConnector {

    private static SessionFactory factory;

    public SessionFactory getSessionFactory() {

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        return factory;
    }

}
