package uni.parthenope.carsharing.repository.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Carica il file hibernate.cfg.xml dalla classe di configurazione
            Configuration configuration = new Configuration();
            configuration.configure(HibernateUtil.class.getClassLoader().getResource("hibernate.cfg.xml"));
            System.out.println("Database connected.");

            // Costruisci la SessionFactory
            sessionFactory = configuration.buildSessionFactory();
            return sessionFactory;
        } catch (Exception e) {
            System.err.println("Session Factory creation failed: " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
