package services;

import models.Region;
import repositories.DBRepositories.DBRegionRepository;
import repositories.RegionRepository;

import java.util.List;

public class RegionService implements GenericService<Region>{

    RegionRepository repository = new DBRegionRepository();

    public RegionService() {
        setRepository(new DBRegionRepository());
    }

    public void setRepository(RegionRepository repository) {
        this.repository = repository;
    }

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
    public void deleteById(int id) {
        repository.deleteById(id);
    }


}
