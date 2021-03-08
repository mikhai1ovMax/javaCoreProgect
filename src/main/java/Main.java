import models.Post;
import models.Region;
import models.Writer;
import repositories.GenericRepository;
import repositories.JsonRegionRepository;
import repositories.WriterRepository;
import views.View;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        view.showStartWindow();
    }
}
