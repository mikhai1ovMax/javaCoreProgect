import controllers.Controller;
import models.Post;
import models.Region;
import models.Writer;
import repositories.GenericRepository;
import repositories.JsonRegionRepository;
import repositories.WriterRepository;
import views.View;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       startProgram();
    }

    public static void startProgram(){
        Scanner in = new Scanner(System.in);
        Controller controller = new Controller();
        View.startWindow();
        int i = in.nextInt();
        controller.setSelectedAction(i);
        View.models();
        i = in.nextInt();
        controller.setRepository(i);
        controller.processRequest();
        in.close();
        startProgram();
    }

}
