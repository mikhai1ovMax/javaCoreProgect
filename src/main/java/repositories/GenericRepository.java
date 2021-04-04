package repositories;

import java.util.List;

public interface GenericRepository <T, Integer>{
    T save(T object);
    T update(T object);
    T getById(Integer id);
    List<T> getAll();
    void deleteById(Integer id);
}
