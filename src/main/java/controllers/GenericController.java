package controllers;

public interface GenericController<T> {
    public void show();
    public T save();
    public T update();
    public void delete();
}
