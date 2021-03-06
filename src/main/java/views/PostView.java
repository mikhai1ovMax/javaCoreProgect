package views;

import controllers.PostController;
import controllers.PostControllerInterlayer;
import models.Post;
import models.Writer;

import java.util.List;
import java.util.Scanner;

public class PostView implements GenericView<Post, Integer> {
    PostControllerInterlayer controller = new PostController();
    Scanner scanner = new Scanner(System.in);
    Post post;

    @Override
    public void printAll() {
        List posts = controller.getAll();
        if(posts != null)
            controller.getAll().forEach(x -> System.out.println(x.toString()));
        else
            System.out.println("no saved data");
    }

    @Override
    public Post Update() {
        post = new Post();
        post.setId(getIdFromConsole());
        System.out.println("enter new content");
        post.setContent(scanner.next());
        post.setWriter(new Writer());
        System.out.println("enter new writer id");
        post.getWriter().setId(scanner.nextInt());
        controller.update(post);
        return post;
    }

    @Override
    public Post save() {
        post = new Post();
        System.out.println("enter post content");
        post.setContent(scanner.next());
        post.setWriter(new Writer());
        System.out.println("enter writer id");
        post.getWriter().setId(scanner.nextInt());
        controller.save(post);
        return post;
    }

    @Override
    public void delete() {
        System.out.println("enter id");
        controller.delete(scanner.nextInt());
    }




}
