package controllers;

import models.Post;
import repositories.JsonPostRepository;
import views.GenericView;
import views.PostView;

public class PostController implements GenericController<Post> {
    PostView view = new PostView();
    JsonPostRepository repository = new JsonPostRepository();

    @Override
    public void show() {
        view.printAll();
    }

    @Override
    public Post save() {
        return repository.save(view.getNewObject());
    }

    @Override
    public Post update() {
        return repository.update(view.getUpdatedObject());
    }

    @Override
    public void delete() {
        repository.deleteById(view.getIdFromConsole());
    }
}
