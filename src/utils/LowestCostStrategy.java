package utils;

import models.MenuItem;
import models.OrderItem;
import models.OrderRequest;
import models.Restaurant;

import java.util.List;

public class LowestCostStrategy implements RestaurantSelectionStrategy {

    @Override
    public Restaurant selectRestaurant(List<Restaurant> restaurants, OrderRequest orderRequest) {
        Restaurant selectedRestaurant = null;
        double lowestCost = Double.MAX_VALUE;

        for (Restaurant restaurant : restaurants) {
            double totalCost = 0;
            for (OrderItem orderItem : orderRequest.getItems()) {
                MenuItem item = restaurant.getMenu().findItemByName(orderItem.getItem().getName());
                totalCost += item.getPrice() * orderItem.getQuantity();
            }

            if (totalCost < lowestCost) {
                lowestCost = totalCost;
                selectedRestaurant = restaurant;
            }
        }

        return selectedRestaurant;
    }
}
