package repositories.hibernateRepositories;

import models.Post;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repositories.PostRepository;

import java.time.LocalDateTime;
import java.util.List;


public class HibernatePostRepository implements PostRepository {
    private Session session;
    private Transaction transaction;
    private HibernateWriterRepository hibernateWriterRepository;

    public HibernatePostRepository(){
        session = SessionBuilder.getSession();
    }

    @Override
    public Post save(Post object) {
        object.setCreated(LocalDateTime.now());
        hibernateWriterRepository = new HibernateWriterRepository();
        object.setWriter(hibernateWriterRepository.getById(object.getWriter().getId()));
        transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        return object;
    }

    @Override
    public Post update(Post object) {
        Post post = getById(object.getId());
        object.setCreated(post.getCreated());
        object.setUpdated(LocalDateTime.now());
        object.setWriter(hibernateWriterRepository.getById(object.getWriter().getId()));
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        return object;
    }

    @Override
    public Post getById(Integer id) {
        return (Post) session.createQuery("from Post where id = :id").getResultList().get(0);
    }

    @Override
    public List<Post> getAll() {
        return session.createQuery("from Post").getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        transaction = session.beginTransaction();
        Post post = new Post();
        post.setId(id);
        session.delete(post);
        transaction.commit();
    }
}
