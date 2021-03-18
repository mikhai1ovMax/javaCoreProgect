package controllers;

import models.Post;
import models.Region;
import repositories.JsonPostRepository;
import repositories.JsonRegionRepository;
import views.PostView;
import views.RegionView;

import java.util.List;

public class RegionController implements GenericController<Region> {

    JsonRegionRepository repository = new JsonRegionRepository();

    @Override
    public List<Region> getAll() {
        return repository.getAll();
    }

    @Override
    public Region save(Region object) {
        return repository.save(object);
    }

    @Override
    public Region update(Region object) {
        return repository.update(object);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
