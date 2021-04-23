package repositories.hibernateRepositories;

import models.Writer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repositories.WriterRepository;

import java.util.List;

public class HibernateWriterRepository implements WriterRepository {
    private Session session;
    private Transaction transaction;

    @Override
    public Writer save(Writer object) {
        return null;
    }

    @Override
    public Writer update(Writer object) {
        return null;
    }

    @Override
    public Writer getById(Integer id) {
        return null;
    }

    @Override
    public List<Writer> getAll() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
