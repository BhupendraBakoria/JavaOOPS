package Generics.Lab1;

import java.util.PriorityQueue;

public class Order implements Comparable<Order> {
    private PriorityQueue<Order> orders;
    private String orderId;
    private boolean isExpress;

    public Order(String orderId, boolean isExpress) {
        this.orderId = orderId;
        this.isExpress = isExpress;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public boolean isExpress() {
        return isExpress;
    }

    public void setExpress(boolean express) {
        isExpress = express;
    }

    public int compareTo(Order o) {
        if (this.isExpress == o.isExpress) {
            return this.orderId.compareTo(o.orderId);
        } else if (this.isExpress) {
            return -1;

        } else {
            return 1;
        }
    }

}
