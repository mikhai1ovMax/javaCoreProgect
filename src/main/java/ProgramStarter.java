import repositories.DBRepositories.DBConnector;
import views.*;

import java.util.Scanner;

public class ProgramStarter {
    GenericView view;
    Scanner scanner = new Scanner(System.in);

    public void start() {
        View.actions();
        int action = scanner.nextInt();
        View.models();
        setView();
        switch (action) {
            case 1 -> view.printAll();
            case 2 -> view.save();
            case 3 -> view.Update();
            case 4 -> view.delete();
            case 5 -> {
                DBConnector.closeConnection();
                System.exit(0);
            }

        }
        restart();
    }

    public void setView() {
        switch (scanner.nextInt()) {
            case 1 -> view = new WriterView();
            case 2 -> view = new PostView();
            case 3 -> view = new RegionView();
        }
    }

    public void restart() {
        start();
    }
}
