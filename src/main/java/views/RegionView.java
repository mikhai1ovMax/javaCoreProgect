package views;

import models.Region;
import repositories.GenericRepository;
import repositories.JsonRegionRepository;

import java.util.List;
import java.util.Scanner;

public class RegionView implements GenericView<Region, Integer> {
    GenericRepository repository = new JsonRegionRepository();
    Scanner scanner = new Scanner(System.in);
    Region region;

    @Override
    public void printAll() {
        List regions = repository.getAll();
        if(regions != null)
            repository.getAll().forEach(x -> System.out.println(x.toString()));
        else
            System.out.println("no saved data");
    }

    @Override
    public void printById(Integer id) {
        System.out.println(repository.getById(id).toString());
    }


    @Override
    public Region getUpdatedObject() {
        region = new Region();
        region.setId(getIdFromConsole());
        System.out.println("enter new region name");
        region.setName(scanner.next());
        return region;
    }

    @Override
    public Region getNewObject() {
        region = new Region();
        System.out.println("enter region name");
        region.setName(scanner.next());
        return region;
    }
}
