package views;

import controllers.RegionController;
import controllers.RegionControllerInterlayer;
import models.Region;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RegionView implements GenericView<Region, Integer> {
    RegionControllerInterlayer controller = new RegionController();
    Scanner scanner = new Scanner(System.in);
    Region region;

    @Override
    public void printAll() {
        List<Region> regions = controller.getAll();
        if (Objects.nonNull(regions) && !regions.isEmpty()) {
            controller.getAll().forEach(region -> System.out.println(region));
        } else
            System.out.println("no saved data");
    }


    @Override
    public Region Update() {
        region = new Region();
        region.setId(getIdFromConsole());
        System.out.println("enter new region name");
        region.setName(scanner.next());
        controller.update(region);
        return region;
    }

    @Override
    public Region save() {
        region = new Region();
        System.out.println("enter region name");
        region.setName(scanner.next());
        controller.save(region);
        return region;
    }

    @Override
    public void delete() {
        System.out.println("enter id");
        controller.delete(scanner.nextInt());
    }
}
