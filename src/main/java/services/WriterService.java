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
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void closeConnection() {
        repository.closeConnection();
    }
}
