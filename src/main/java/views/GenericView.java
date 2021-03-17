package views;

import java.util.Scanner;

public interface GenericView<T, Integer> {
    public void printAll();
    public void printById(Integer id);
    public T getUpdatedObject();
    public T getNewObject();
    public default int getIdFromConsole(){
        System.out.println("enter Id");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
