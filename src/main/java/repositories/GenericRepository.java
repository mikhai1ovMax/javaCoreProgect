package repositories;

import java.util.List;

public interface GenericRepository <T, Integer>{
    static final String URL = "jdbc:mysql://localhost:3306/javaCoreProgect_DB";
    static final String USERNAME = "root";
    static final String PASSWORD = "1";

    T save(T object);
    T update(T object);
    T getById(Integer id);
    List<T> getAll();
    void deleteById(Integer id);
    void closeConnection();
}
