package controllers;


import repositories.GenericRepository;
import repositories.JsonPostRepository;
import repositories.JsonRegionRepository;
import repositories.JsonWriterRepository;
import views.View;

import java.util.Scanner;

public class Controller {

    private int selectedAction;
    private GenericRepository repository;
    private Scanner in = new Scanner(System.in);

    private Controller() {
    }

    public  int getSelectedAction() {
        return selectedAction;
    }

    public void setSelectedAction(int selectedAction) {
        this.selectedAction = selectedAction;
    }

    public GenericRepository getRepository() {
        return repository;
    }

    public void setRepository(int num) {
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
        switch (selectedAction){
            case 1 -> View.savedData(repository);
            case 2 ->
        }
    }

    public void startProgram() {
        View.startWindow();
        setSelectedAction(in.nextInt());
        View.models();
        setRepository(in.nextInt());
        processRequest();
        in.close();


}
