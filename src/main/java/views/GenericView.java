package views;

import java.util.Scanner;

public interface GenericView<T, Integer> {
    public void printAll();
    //public void printById(Integer id);
    public T Update();
    public T save();
    public void delete();
    public default int getIdFromConsole(){
        System.out.println("enter Id");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public void exit();

}
