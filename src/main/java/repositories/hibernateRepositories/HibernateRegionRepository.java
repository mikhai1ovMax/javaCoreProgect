package repositories.hibernateRepositories;

import models.Region;
import org.hibernate.Session;
import repositories.RegionRepository;

import java.util.List;

public class HibernateRegionRepository implements RegionRepository {
    private Session session;


    public HibernateRegionRepository() {
        session = SessionBuilder.getSession();
    }

    @Override
    public Region save(Region object) {
        session.save(object);
        return object;
    }

    @Override
    public Region update(Region object) {
        session.update(object);
        return object;
    }

    @Override
    public Region getById(Integer id) {
        return (Region) session.createQuery("from Region where id = :id").getResultList().get(0);

    }

    @Override
    public List<Region> getAll() {
        return (List<Region>) session.createQuery("from Region").getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        session.createQuery("delete from Region where id = :id");
    }
}
