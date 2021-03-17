package views;

import models.Writer;
import models.WriterFactory;
import repositories.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WriterView implements GenericView<Writer, Integer> {
    GenericRepository repository = new JsonWriterRepository();
    Scanner scanner = new Scanner(System.in);
    Writer writer;

    @Override
    public void printAll() {
        List writers = repository.getAll();
        if(writers != null)
            repository.getAll().forEach(x -> System.out.println(x.toString()));
        else
            System.out.println("no saved data");
    }

    @Override
    public void printById(Integer id) {
        System.out.println(repository.getById(id).toString());
    }

    @Override
    public Writer getUpdatedObject() {
        writer = getWriterWithoutId();
        writer.setId(getIdFromConsole());
        return writer;
    }

    @Override
    public Writer getNewObject() {
        return getWriterWithoutId();
    }

    private Writer getWriterWithoutId() {
        PostRepository postsRepo = new JsonPostRepository();
        RegionRepository regionRepo = new JsonRegionRepository();
        WriterFactory writerFactory = new WriterFactory();

        System.out.println("enter name");
        writerFactory.setFirstName(scanner.next());
        System.out.printf("enter last name");
        writerFactory.setLastName(scanner.next());
        System.out.println("enter posts id");
        List<Integer> postsId = Arrays.stream(scanner.nextLine()
                .split(" +"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        writerFactory.setPostsByIdList(postsId);
        System.out.println("enter region");
        writerFactory.setRegionById(scanner.nextInt());
        return writerFactory.getWriter();
    }
}
