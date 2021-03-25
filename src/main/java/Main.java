import repositories.DBRepositories.DBPostRepository;
import repositories.DBRepositories.DBRegionRepository;
import repositories.DBRepositories.DBWriterRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ProgramStarter starter = new ProgramStarter();
//        starter.start();
        DBPostRepository dbPostRepository = new DBPostRepository();
        DBRegionRepository dbRegionRepository = new DBRegionRepository();
        DBWriterRepository dbWriterRepository = new DBWriterRepository();
        //System.out.println(dbPostRepository.getById(1));
        dbPostRepository.deleteById(1);
    }



}
