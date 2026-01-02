package Generics.Lab1;

public class Book extends  Item{
    String author;

    public Book(String id, String name, double price, int quantity, String author){
        super(id, name, price, quantity);
        this.author = author;
    }
}
