package controllers;

import models.Region;
import models.Writer;
import repositories.JsonRegionRepository;
import repositories.JsonWriterRepository;
import views.RegionView;
import views.WriterView;

import java.util.List;

public class WriterController implements GenericController<Writer> {
    JsonWriterRepository repository = new JsonWriterRepository();

    @Override
    public List<Writer> getAll() {
        return repository.getAll();
    }

    @Override
    public Writer save(Writer object) {
        return repository.save(object);
    }

    @Override
    public Writer update(Writer object) {
        return repository.update(object);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
