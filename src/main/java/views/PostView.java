package views;

import models.Post;
import repositories.GenericRepository;
import repositories.JsonPostRepository;

import java.util.List;
import java.util.Scanner;

public class PostView implements GenericView<Post, Integer> {
    GenericRepository repository = new JsonPostRepository();
    Scanner scanner = new Scanner(System.in);
    Post post;

    @Override
    public void printAll() {
        List posts = repository.getAll();
        if(posts != null)
            repository.getAll().forEach(x -> System.out.println(x.toString()));
        else
            System.out.println("no saved data");
    }

    @Override
    public void printById(Integer id) {
        System.out.println(repository.getById(id).toString());
    }

    @Override
    public Post getUpdatedObject() {
        post = new Post();
        post.setId(getIdFromConsole());
        System.out.println("enter new content");
        post.setContent(scanner.next());
        return post;
    }

    @Override
    public Post getNewObject() {
        post = new Post();
        System.out.println("enter post content");
        post.setContent(scanner.next());
        return post;

    }
}
