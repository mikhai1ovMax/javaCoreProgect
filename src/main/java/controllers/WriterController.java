package controllers;

import models.Writer;
import repositories.jsonRepositoires.JsonWriterRepository;
import services.WriterService;

import java.util.List;

public class WriterController implements GenericController<Writer> {

    WriterService service = new WriterService();

    @Override
    public List<Writer> getAll() {
        return service.getAll();
    }

    @Override
    public Writer save(Writer object) {
        return service.save(object);
    }

    @Override
    public Writer update(Writer object) {
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
