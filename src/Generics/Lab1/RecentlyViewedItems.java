package Generics.Lab1;

import java.util.LinkedList;

public class RecentlyViewedItems {
    private LinkedList<Item> items;
    private final int MAX_SIZE = 5;

    public RecentlyViewedItems() {
        items = new LinkedList<>();
    }

    public void addRecentlyViewedItem(Item item) {
        if (items.contains(item)) {
            items.remove(item);
        }
        items.addFirst(item);
        if (items.size() > MAX_SIZE) {
            items.removeLast();
        }
    }

    public LinkedList<Item> getAllRecentlyViewedItems() {
        return items;
    }

}
