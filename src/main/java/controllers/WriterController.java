package controllers;

import models.Writer;
import services.WriterService;
import services.WriterServiceInterlayer;

import java.util.List;

public class WriterController implements WriterControllerInterlayer {

    WriterServiceInterlayer service = new WriterService();

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
}
