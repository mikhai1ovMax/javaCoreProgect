package views;

import controllers.Controller;

import java.sql.SQLOutput;
import java.util.Scanner;

public class View {

    Scanner in = new Scanner(System.in);

    public void showStartWindow() {
        System.out.println("Hi!");
        System.out.println("What do want to do?");
        System.out.println("1 - see saved data");
        System.out.println("2 - save new data");
        System.out.println("3 - edit");
        System.out.println("4 - delete");
    }

    public void showModels(){
        System.out.println("1 - Writer");
        System.out.println("2 - Post");
        System.out.println("3 - Region");
    }

    public void startProgram() {
        showStartWindow();
        Controller.setSelectedAction(in.nextInt());
        showModels();
        Controller.setSelectedModel(in.nextInt());
        in.close();
    }
}
