package views;

import controllers.WriterController;
import models.Writer;
import models.WriterFactory;
import repositories.*;
import repositories.jsonRepositoires.JsonPostRepository;
import repositories.jsonRepositoires.JsonRegionRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WriterView implements GenericView<Writer, Integer> {
    WriterController controller = new WriterController();
    Scanner scanner = new Scanner(System.in);
    Writer writer;

    @Override
    public void printAll() {
        List writers = controller.getAll();
        if(writers != null)
            controller.getAll().forEach(x -> System.out.println(x.toString()));
        else
            System.out.println("no saved data");
    }


    @Override
    public Writer Update() {
        writer = getWriterWithoutId();
        writer.setId(getIdFromConsole());
        controller.update(writer);
        return writer;
    }

    @Override
    public Writer save() {
        return controller.save(getWriterWithoutId());
    }

    @Override
    public void delete() {
        System.out.println("enter id");
        controller.delete(scanner.nextInt());
    }

    @Override
    public void exit() {
        controller.closeConnection();
    }


    private Writer getWriterWithoutId() {
        PostRepository postsRepo = new JsonPostRepository();
        RegionRepository regionRepo = new JsonRegionRepository();
        WriterFactory writerFactory = new WriterFactory();

        System.out.println("enter name");
        writerFactory.setFirstName(scanner.next());
        System.out.println("enter last name");
        writerFactory.setLastName(scanner.next());
        System.out.println("enter posts id");
        List<Integer> postsId = Arrays.stream(scanner.nextLine()
                .split(" +"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        writerFactory.setPostsByIdList(postsId);
        System.out.println("enter region id");
        writerFactory.setRegionById(scanner.nextInt());
        return writerFactory.getWriter();
    }
}
