package services;

import java.util.List;

public interface GenericService<T> {
    public List<T> getAll();
    public T save(T object);
    public T update(T object);
    public void deleteById(int id);
    public void closeConnection();
}
