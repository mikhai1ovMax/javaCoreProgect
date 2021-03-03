import models.Post;
import models.Region;
import models.Writer;
import repositories.JsonWriterRepository;
import repositories.WriterRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WriterRepository writerRepository = new JsonWriterRepository();
        List<Post> posts = Arrays.asList(
                new Post(0, "123", LocalDateTime.now()),
                new Post(0, "321", LocalDateTime.now())
                );

        writerRepository.saveData(new Writer(0,
                "an",
                "Peter",
                posts,
                new Region(1, "132")));
    }
}
