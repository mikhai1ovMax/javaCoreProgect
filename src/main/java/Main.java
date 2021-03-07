import models.Post;
import models.Region;
import models.Writer;
import repositories.GenericRepository;
import repositories.JsonRegionRepository;
import repositories.WriterRepository;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       Region region = new Region(1, "11");
        GenericRepository genericRepository = new JsonRegionRepository();
        genericRepository.save(region);
    }
}
