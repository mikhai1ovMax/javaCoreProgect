package repositories.hibernateRepositories;

import models.Region;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repositories.RegionRepository;

import java.util.List;

public class HibernateRegionRepository implements RegionRepository {
    private Session session;


    public HibernateRegionRepository() {
        session = SessionBuilder.getSession();
    }

    @Override
    public Region save(Region object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        return object;
    }

    @Override
    public Region update(Region object) {
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        return object;
    }

    @Override
    public Region getById(Integer id) {
        return (Region) session.createQuery("from Region where id = :id").getResultList().get(0);
    }

    @Override
    public List<Region> getAll() {
        return session.createQuery("from Region").getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        session.beginTransaction();
        Region region = new Region();
        region.setId(id);
        session.delete(region);
        session.getTransaction().commit();
    }
}
