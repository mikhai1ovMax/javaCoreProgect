package controllers;

import views.View;

import java.util.Scanner;

public class MainController {
    private GenericController genericController;
    private int action;
    Scanner scanner = new Scanner(System.in);

    public void start() {
        setAction();
        setGenericController();
        processRequest();
        restart();
    }

    private void setGenericController() {
        View.models();
        switch (scanner.nextInt()) {
            case 1:
                genericController = new WriterController();
                break;
            case 2:
                genericController = new PostController();
                break;
            case 3:
                genericController = new RegionController();
                break;
        }
    }

    private void setAction() {
        View.actions();
        this.action = scanner.nextInt();
    }

    private void processRequest() {
        switch (action) {
            case 1:
                genericController.show();
                break;
            case 2:
                genericController.save();
                break;
            case 3:
                genericController.update();
                break;
            case 4:
                genericController.delete();
                break;
        }
    }
    private void restart(){
        start();
    }
}
