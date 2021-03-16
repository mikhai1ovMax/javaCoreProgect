package controllers;


import models.Post;
import models.Region;
import models.Writer;
import repositories.GenericRepository;
import repositories.JsonPostRepository;
import repositories.JsonRegionRepository;
import repositories.JsonWriterRepository;
import views.View;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class OldController {

    private int selectedAction;
    private int selectedModelNum;
    private GenericRepository repository;
    Scanner in = new Scanner(System.in);

    public int getSelectedAction() {
        return selectedAction;
    }

    public void setSelectedAction(int selectedAction) {
        this.selectedAction = selectedAction;
    }

    public GenericRepository getRepository() {
        return repository;
    }

    public void setRepository(int num) {
        selectedModelNum = num;
        switch (num) {
            case 1:
                repository = new JsonWriterRepository();
                break;
            case 2:
                repository = new JsonPostRepository();
                break;
            case 3:
                repository = new JsonRegionRepository();
                break;
        }
    }

    public void setRepository(GenericRepository repository) {
        this.repository = repository;
    }

    public void processRequest() {
        switch (selectedAction) {
            case 1: View.savedData(repository);
                break;
            case 2: saveNewObject();
                break;
            case 3: updateObject();
                break;
            case 4: deleteObjectById();
                break;
        }
        in.close();
    }

    private void deleteObjectById() {
        View.inputInstruction();
        repository.deleteById(in.nextInt());
    }

    private void updateObject() {
        int id;
        String name;
        switch (selectedModelNum) {
            case 1:
                View.writerUpdateInstruction();
                id = in.nextInt();
                name = in.next();
                String lastname = in.next();
                List posts = Arrays.asList(in.nextLine().split("\\s+"));
                Region region = (Region) repository.getById(in.nextInt());
                Writer writer = (Writer) repository.update(new Writer(id, name, lastname, posts, region));
                System.out.println(writer);
                break;
            case 2:
                View.postUpdateInstruction();
                String content = in.nextLine();
                Post post = (Post) repository.update(new Post(content));
                System.out.println(post);
                break;
            case 3:
                View.regionUpdateInstruction();
                id = in.nextInt();
                name = in.next();
                Region reg = (Region) repository.update(new Region(id, name));
                System.out.println(reg);
                break;
        }
    }

    private void saveNewObject() {
        String name;
        String content;
        switch (selectedModelNum) {
            case 1:
                View.writerInputInstruction();
                System.out.println("name: ");
                name = in.next();
                System.out.println("last name: ");
                String lastname = in.next();
                System.out.println("posts: ");
                List posts = Arrays.asList(in.next().split("\\s+"));
                System.out.println("region: ");
                Region region = (Region) repository.getById(in.nextInt());
                Writer writer = (Writer) repository.save(new Writer(name, lastname, posts, region));
                System.out.println(writer);
                break;
            case 2:
                View.postInputInstruction();
                content = in.next();
                Post post = (Post) repository.save(new Post(content));
                System.out.println(post);
                break;

            case 3:
                View.regionInputInstruction();
                content = in.next();
                Region reg = (Region) repository.save(new Region(content));
                System.out.println(reg);
                break;
        }
    }

}