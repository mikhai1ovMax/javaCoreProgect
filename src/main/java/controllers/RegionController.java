package controllers;

import models.Post;
import models.Region;
import repositories.JsonPostRepository;
import repositories.JsonRegionRepository;
import views.PostView;
import views.RegionView;

public class RegionController implements GenericController<Region> {
    RegionView view = new RegionView();
    JsonRegionRepository repository = new JsonRegionRepository();

    @Override
    public void show() {
        view.printAll();
    }

    @Override
    public Region save() {
        return repository.save(view.getNewObject());
    }

    @Override
    public Region update() {
        return repository.update(view.getUpdatedObject());
    }

    @Override
    public void delete() {
        repository.deleteById(view.getIdFromConsole());
    }
}
