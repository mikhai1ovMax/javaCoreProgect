package controllers;

import models.Region;
import models.Writer;
import repositories.JsonRegionRepository;
import repositories.JsonWriterRepository;
import views.RegionView;
import views.WriterView;

public class WriterController implements GenericController<Writer> {
    WriterView view = new WriterView();
    JsonWriterRepository repository = new JsonWriterRepository();

    @Override
    public void show() {
        view.printAll();
    }

    @Override
    public Writer save() {
        return repository.save(view.getNewObject());
    }

    @Override
    public Writer update() {
        return repository.update(view.getUpdatedObject());
    }

    @Override
    public void delete() {
        repository.deleteById(view.getIdFromConsole());
    }
}
