package repositories.hibernateRepositories;

import models.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repositories.RegionRepository;

import java.util.List;

public class HibernateRegionRepository implements RegionRepository {
    private static SessionFactory sessionFactory;

    public HibernateRegionRepository() {
        sessionFactory = new Configuration().buildSessionFactory();
    }

    @Override
    public Region save(Region object) {
        return null;
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
        Transaction transaction = session.beginTransaction();
        List regions = session.createQuery("FROM Region").list();
        transaction.commit();
        session.close();
        return regions;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
