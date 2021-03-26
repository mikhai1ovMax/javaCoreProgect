package controllers;

import models.Post;
import repositories.PostRepository;
import repositories.jsonRepositoires.JsonPostRepository;
import services.GenericService;
import services.PostService;

import java.util.List;

public class PostController implements GenericController<Post> {
    PostService service = new PostService();

    @Override
    public List<Post> getAll() {
        return service.getAll();
    }

    @Override
    public Post save(Post object) {
        return service.save(object);
    }

    @Override
    public Post update(Post object) {
        return service.update(object);
    }

    @Override
    public void delete(int id) {
        service.deleteById(id);
    }
}
