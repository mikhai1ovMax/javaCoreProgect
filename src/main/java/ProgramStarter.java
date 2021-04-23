import views.*;

import java.util.Scanner;
import repositories.hibernateRepositories.SessionBuilder;

public class ProgramStarter {
    GenericView view;
    Scanner scanner = new Scanner(System.in);

    public void start() {
        View.actions();
        int action = scanner.nextInt();
        View.models();
        setView();
        SessionBuilder.openSession();
        switch (action) {
            case 1:
                view.printAll();
                break;
            case 2:
                System.out.println(view.save());
                break;
            case 3:
                System.out.println(view.Update());
                break;
            case 4:
                view.delete();
                break;
            case 5:
                SessionBuilder.closeSession();
                System.exit(0);
                break;


        }
        restart();
    }

    public void setView() {
        switch (scanner.nextInt()) {
            case 1:
                view = new WriterView();
                break;
            case 2:
                view = new PostView();
                break;
            case 3:
                view = new RegionView();
                break;
        }
    }

    public void restart() {
        start();
    }
}
