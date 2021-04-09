package services;

import models.Post;
import repositories.JDBCRepositories.JDBCPostRepository;
import repositories.PostRepository;

import java.util.List;

public class PostService implements PostServiceInterlayer {

    PostRepository repository;

    public PostService() {
        setRepository(new JDBCPostRepository());
    }

    public void setRepository(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Post> getAll() {
        return repository.getAll();
    }

    @Override
    public Post save(Post object) {
        return repository.save(object);
    }

    @Override
    public Post update(Post object) {
        return repository.update(object);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
