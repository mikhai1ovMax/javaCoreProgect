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
        Controller controller = new Controller();
        Scanner in = new Scanner(System.in);
        View.startWindow();
        controller.setSelectedAction(in.nextInt());
        View.models();
        controller.setRepository(in.nextInt());
        controller.processRequest();
        in.close();
    }
}
