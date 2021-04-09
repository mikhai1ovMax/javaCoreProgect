package services;

import models.Writer;
import repositories.JDBCRepositories.JDBCWriterRepository;
import repositories.WriterRepository;

import java.util.List;

public class WriterService implements WriterServiceInterlayer{

    WriterRepository repository = new JDBCWriterRepository();

    public WriterService() {
        setRepository(new JDBCWriterRepository());
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


}
