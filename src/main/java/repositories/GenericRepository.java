package repositories;

public interface GenericRepository <T, Integer>{
    public void saveData(T object);
    public T readData();
    public void updateData();
}
