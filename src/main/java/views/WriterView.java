package views;

import controllers.WriterController;
import controllers.WriterControllerInterlayer;
import models.Region;
import models.Writer;

import java.util.List;
import java.util.Scanner;

public class WriterView implements GenericView<Writer, Integer> {
    WriterControllerInterlayer controller = new WriterController();
    Scanner scanner = new Scanner(System.in);
    Writer writer;

    @Override
    public void printAll() {
        List writers = controller.getAll();
        if(writers != null)
            writers.forEach(x -> System.out.println(x.toString()));
        else
            System.out.println("no saved data");
    }


    @Override
    public Writer Update() {
        writer.setId(getIdFromConsole());
        writer = getWriterWithoutId();
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

    private Writer getWriterWithoutId() {
        Writer writer = new Writer();
        System.out.println("enter name");
        writer.setFirstName(scanner.next());
        System.out.println("enter last name");
        writer.setLastName(scanner.next());
        System.out.println("enter region id");
        writer.setRegion(new Region());
        writer.getRegion().setId(scanner.nextInt());
        return writer;
    }
}
