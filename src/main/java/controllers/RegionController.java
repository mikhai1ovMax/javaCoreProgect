package controllers;

import models.Region;
import services.RegionService;
import services.RegionServiceInterlayer;

import java.util.List;

public class RegionController implements RegionControllerInterlayer {

    RegionServiceInterlayer service = new RegionService();

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
}
