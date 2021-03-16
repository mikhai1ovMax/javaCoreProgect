package views;

public interface GenericView<T, Integer> {
    public void printAll();
    public void printById(Integer id);
    public T getUpdatedObject();
    public T getNewObject();
}
