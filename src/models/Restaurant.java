package models;

import java.util.List;

public class Restaurant {
    private String name;
    private int capacity;
    private Menu menu;
    private int currentCapacity;
    private double rating;

    public Restaurant(String name, int capacity, Menu menu, double rating) {
        this.name = name;
        this.capacity = capacity;
        this.menu = menu;
        this.currentCapacity = capacity;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public double getRating() {
        return rating;
    }

    public boolean canProcessOrder(int items) {
        return currentCapacity >= items;
    }

    public void processOrder(int items) {
        currentCapacity -= items;
    }

    public void updateMenu(Menu menu) {
        this.menu = menu;
    }

    public boolean canFulfillOrder(List<OrderItem> orderItems) {
        for (OrderItem orderItem : orderItems) {
            if (menu.findItemByName(orderItem.getItem().getName()) == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + currentCapacity + "/" + capacity + ", Rating: " + rating + ")";
    }

}
