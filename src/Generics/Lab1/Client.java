package Generics.Lab1;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
//        List<Item> ItemList = new ArrayList<>();

//        ItemList.add(new Book("101", "The Great Gatsby", 100.21, 2, "My Name"));
//        ItemList.add(new Electronics("102", "Electric Kettle", 749.50, 100, 2));
//        ItemList.add(new Clothing("103", "Night Lingerie", 399, 2, "Small"));
//
//        System.out.println();
//        System.out.println("Before sorting");
//        System.out.println("-----------------");
//        for (Item i : ItemList) {
//            System.out.println(i.getName()+": $"+i.getPrice());
//        }
//
//        System.out.println();
//
//        Collections.sort(ItemList);
//
//        System.out.println("After sorting");
//        System.out.println("-----------------");
//        for (Item p: ItemList) {
//            System.out.println(p.getName()+": $"+p.getPrice());
//        }
//        Inventory<Book> bookInventory = new Inventory<>();
//        bookInventory.addItem(new Book("101", "The Great Gatsby", 100.21, 2, "My Name"));
//        bookInventory.addItem(new Book("102", "The Sorcerer", 100.21, 2, "My Name"));
//
//        for (Book b: bookInventory.getAllItems()) {
//            System.out.println("Book list are" + b.getName());
//        }

//        RecentlyViewedItems recentlyViewedItems = new RecentlyViewedItems();
//        for (int i=1; i<=7; i++) {
//            recentlyViewedItems.addRecentlyViewedItem(new Book("101"+i,
//                    "The Great Gatsby", 100.21, 2, "My Name"));
//        }
//
//        System.out.println("Recently viewed items are: ");
//        for (Item item : recentlyViewedItems.getAllRecentlyViewedItems()) {
//            System.out.println(item.getId());
//        }

        ProcessOrder processOrder = new ProcessOrder();
        processOrder.addOrder(new Order("001", false));
        processOrder.addOrder(new Order("002", true));
        processOrder.addOrder(new Order("003", true));

        System.out.println("Process order are: ");
        while (processOrder.getSize() > 0) {
            Order order = processOrder.processOrder();
            System.out.println("process order id: "+ order.getOrderId());
        }





    }
}
