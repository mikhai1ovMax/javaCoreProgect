package controllers;

import models.Region;
import repositories.jsonRepositoires.JsonRegionRepository;
import services.RegionService;

import java.util.List;

public class RegionController implements GenericController<Region> {

    RegionService service = new RegionService();

    @Override
    public List<Region> getAll() {
        return service.getAll();
    }

    @Override
    public Region save(Region object) {
        return service.save(object);
    }

    @Override
    public Region update(Region object) {
        return service.update(object);
    }

    @Override
    public void delete(int id) {
        service.deleteById(id);
    }

    @Override
    public void closeConnection() {
        service.closeConnection();
    }
}
