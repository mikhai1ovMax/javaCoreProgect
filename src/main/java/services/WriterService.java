package services;

import models.Writer;
import repositories.DBRepositories.DBWriterRepository;
import repositories.WriterRepository;

import java.util.List;

public class WriterService implements GenericService<Writer>{

    WriterRepository repository = new DBWriterRepository();

    public WriterService() {
        setRepository(new DBWriterRepository());
    }

    public void setRepository(WriterRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Writer> getAll() {
        List writer = repository.getAll();
        repository.closeConnection();
        return writer;
    }

    @Override
    public Writer save(Writer object) {
        Writer writer = repository.save(object);
        repository.closeConnection();
        return writer;
    }

    @Override
    public Writer update(Writer object) {
        Writer writer = repository.update(object);
        repository.closeConnection();
        return writer;
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
        repository.closeConnection();
    }


}
