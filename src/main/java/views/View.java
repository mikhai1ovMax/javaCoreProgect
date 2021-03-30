package views;

import repositories.GenericRepository;

import java.util.List;

public class View {
    private View() {
    }

    public static void actions() {
        System.out.println("What do want to do?");
        System.out.println("1 - see saved data");
        System.out.println("2 - save new data");
        System.out.println("3 - update");
        System.out.println("4 - delete");
        System.out.println("5 - exit");
    }

    public static void models() {
        System.out.println("1 - Writer");
        System.out.println("2 - Post");
        System.out.println("3 - Region");
    }
}
