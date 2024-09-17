package models;

public class Order {
    private Restaurant restaurant;
    private double cost;
    private String status;

    public Order(Restaurant restaurant, double cost) {
        this.restaurant = restaurant;
        this.cost = cost;
        this.status = "Accepted";
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public double getCost() {
        return cost;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order from " + restaurant.getName() + " - Total Cost: " + cost + " Status: " + status;
    }


}
