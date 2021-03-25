package controllers;

import models.Post;
import repositories.jsonRepositoires.JsonPostRepository;

import java.util.List;

public class PostController implements GenericController<Post> {
    JsonPostRepository repository = new JsonPostRepository();

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
    public void delete(int id) {
        repository.deleteById(id);
    }
}
