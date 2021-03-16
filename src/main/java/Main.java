import controllers.OldController;
import views.View;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       startProgram();
    }

    public static void startProgram(){
        Scanner in = new Scanner(System.in);
        OldController oldController = new OldController();
        View.startWindow();
        int i = in.nextInt();
        oldController.setSelectedAction(i);
        View.models();
        i = in.nextInt();
        oldController.setRepository(i);
        oldController.processRequest();
        in.close();
        startProgram();
    }

}
