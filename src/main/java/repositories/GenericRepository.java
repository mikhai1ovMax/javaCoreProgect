package repositories;

import java.util.List;

public interface GenericRepository <T, Integer>{
    public void saveData(T object);
    public List readData();
    public void updateData();
}
