package services;

import models.*;
import utils.RestaurantSelectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private RestaurantService restaurantService;
    private List<Order> orderList;

    public OrderService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
        this.orderList = new ArrayList<>();
    }

    public Order placeOrder(OrderRequest orderRequest, RestaurantSelectionStrategy strategy) {
        Restaurant restaurant = restaurantService.selectRestaurantForOrder(orderRequest, strategy);
        if (restaurant == null) {
            throw new RuntimeException("No restaurant can fulfill this order.");
        }

        double totalCost = 0;
        for (OrderItem item : orderRequest.getItems()) {
            List<MenuItem> restMenuItems = restaurant.getMenu().getItems();
            for (MenuItem menuItem : restMenuItems) {
                if (menuItem.getName().equals(menuItem.getName())) {
                    totalCost += menuItem.getPrice() + item.getQuantity();
                }
            }

        }

        restaurant.processOrder(orderRequest.getTotalItems());
        Order newOrder = new Order(restaurant, totalCost);

        orderList.add(newOrder);

        return newOrder;
    }
}
