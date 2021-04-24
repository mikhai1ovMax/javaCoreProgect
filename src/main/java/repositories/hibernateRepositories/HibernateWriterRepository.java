package repositories.hibernateRepositories;

import models.Writer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import repositories.WriterRepository;

import java.util.List;

public class HibernateWriterRepository implements WriterRepository {
    private Session session;
    private Transaction transaction;

    public HibernateWriterRepository(){
        session = SessionBuilder.getSession();
    }
    @Override
    public Writer save(Writer object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        return object;
    }

    @Override
    public Writer update(Writer object) {
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        return object;
    }

    @Override
    public Writer getById(Integer id) {
       return session.get(Writer.class, id);
    }

    @Override
    public List<Writer> getAll() {
        return session.createQuery("from Writer").getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        Writer writer = new Writer();
        writer.setId(id);
        session.beginTransaction();
        session.delete(writer);
        session.getTransaction().commit();
    }
}
