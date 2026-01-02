package Generics.Lab1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory<T extends Item> {
    private HashMap<String, T> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void addItem(T item) {
        if (item.getQuantity() <=0) {
            System.out.println("Invalid item quantity");
            return;
        }

        if(items.containsKey(item.getId())) {
            System.out.println("Item already exists");
            return;
        }
        items.put(item.getId(), item);
    }

    public void removeItem(String id) {
        if (!items.containsKey(id)) {
            System.out.println("Invalid item id");
            return;
        }
        items.remove(id);
    }

    public T getItem(String id) {
        if (!items.containsKey(id)) {
            System.out.println("Invalid item id");
            return null;
        }
        return items.get(id);
    }

    public List<T> getAllItems() {
        return new ArrayList<>(items.values());
    }



}
