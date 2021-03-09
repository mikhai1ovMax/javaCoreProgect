package controllers;


import models.Post;
import models.Region;
import models.Writer;
import repositories.GenericRepository;
import repositories.JsonPostRepository;
import repositories.JsonRegionRepository;
import repositories.JsonWriterRepository;
import views.View;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controller {

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
            case 1 -> repository = new JsonWriterRepository();
            case 2 -> repository = new JsonPostRepository();
            case 3 -> repository = new JsonRegionRepository();
        }
    }

    public void setRepository(GenericRepository repository) {
        this.repository = repository;
    }

    public void processRequest() {
        switch (selectedAction) {
            case 1 -> View.savedData(repository);
            case 2 -> getModel();
            //TODO
        }
    }


    private void getModel() {
        switch (selectedModelNum) {

            case 1 -> {
                View.writerInputInstruction();
                int id = in.nextInt();
                String name = in.next();
                String lastname = in.next();
                List posts = Arrays.asList(in.nextLine().split("\\s+"));
                Region region = (Region) repository.getById(in.nextInt());
                repository.save(new Writer(id, name, lastname, posts, region));
            }
            case 2 -> {
                View.postInputInstruction();
                int i  = in.nextInt();
                String s = in.next();
                repository.save(new Post(i, s, LocalDateTime.now()));
            }

            case 3 -> {
                View.regionInputInstruction();
                int i  = in.nextInt();
                String s = in.next();
                repository.save(new Region(i, s));
            }
        }
    }

}
