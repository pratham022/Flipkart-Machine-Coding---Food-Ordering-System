package utils;

import models.OrderRequest;
import models.Restaurant;

import java.util.List;

public interface RestaurantSelectionStrategy {
    Restaurant selectRestaurant(List<Restaurant> restaurants, OrderRequest orderRequest);
}
