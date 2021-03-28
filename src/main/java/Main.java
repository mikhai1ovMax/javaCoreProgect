import models.Post;
import models.Region;
import models.Writer;
import repositories.DBRepositories.DBPostRepository;
import repositories.DBRepositories.DBRegionRepository;
import repositories.DBRepositories.DBWriterRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProgramStarter starter = new ProgramStarter();
        starter.start();
    }
}
