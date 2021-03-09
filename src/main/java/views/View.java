package views;

import controllers.Controller;
import repositories.GenericRepository;

import java.util.List;
import java.util.Scanner;

public class View {


    private View() {
    }

    public static void startWindow() {
        System.out.println("What do want to do?");
        System.out.println("1 - see saved data");
        System.out.println("2 - save new data");
        System.out.println("3 - edit");
        System.out.println("4 - delete");
    }

    public static void models() {
        System.out.println("1 - Writer");
        System.out.println("2 - Post");
        System.out.println("3 - Region");
    }


    public static void savedData(GenericRepository repository) {
        List data = repository.getAll();
        if (data != null)
            data.stream().forEach(x -> System.out.println(x.toString()));
        else
            System.out.println("no saved data");
    }

    public static void postInputInstruction() {
        System.out.println("enter id and content(split them using enter");
    }

    public static void  RegionInputInstruction(){
        System.out.println("enter id and region name(split them using enter");
    }


}
