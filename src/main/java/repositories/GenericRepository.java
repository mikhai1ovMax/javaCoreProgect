package repositories;

import java.util.List;

public interface GenericRepository <T, Integer>{
    void save(T object);
    void update(T object);
    T getById(Integer id);
    List<T> getAll();
    void deleteById(Integer id);
}
