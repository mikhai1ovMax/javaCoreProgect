package repositories.hibernateRepositories;

import models.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import repositories.RegionRepository;

import java.util.List;

public class HibernateRegionRepository implements RegionRepository {
    private static SessionFactory sessionFactory;



    public HibernateRegionRepository() {
        sessionFactory = SessionFactoryBuilder.getSessionFactory();

    }

    @Override
    public Region save(Region object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        return object;
    }

    @Override
    public Region update(Region object) {
        return null;
    }

    @Override
    public Region getById(Integer id) {
        return null;
    }

    @Override
    public List<Region> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List regions = session.createQuery("from Region").list();
        session.getTransaction().commit();
        return regions;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
