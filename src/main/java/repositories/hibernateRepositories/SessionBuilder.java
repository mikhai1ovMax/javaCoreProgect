package repositories.hibernateRepositories;

import models.Post;
import models.Region;
import models.Writer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionBuilder {

    private static Session session;

    private SessionBuilder() {
    }

    private static SessionFactory buildSessionFactory() {
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Region.class);
        configuration.addAnnotatedClass(Post.class);
        configuration.addAnnotatedClass(Writer.class);

        ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static Session getSession() {
        if(session == null)
            openSession();
        return session;
    }
    public static void openSession(){
        session = buildSessionFactory().openSession();
    }

    public static void closeSession(){
        session.close();
    }
}
