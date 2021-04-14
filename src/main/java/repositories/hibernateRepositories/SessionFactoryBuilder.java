package repositories.hibernateRepositories;

import models.Post;
import models.Region;
import models.Writer;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

class SessionFactoryBuilder {

    private static SessionFactory sessionFactory;

    private SessionFactoryBuilder() {
    }

    private static void buildSessionFactory () {
        Configuration configuration = new Configuration();
        ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        configuration.addAnnotatedClass(Post.class);
        configuration.addAnnotatedClass(Region.class);
        configuration.addAnnotatedClass(Writer.class);
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null)
            buildSessionFactory();
        return sessionFactory;
    }
}
