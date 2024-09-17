package services;

import models.Menu;
import models.MenuItem;
import models.OrderRequest;
import models.Restaurant;
import utils.RestaurantSelectionStrategy;

import java.util.*;

public class RestaurantService {
    private List<Restaurant> restaurants;

    public RestaurantService() {
        restaurants = new ArrayList<>();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void addMenuItemToRestaurantMenu(String restaurantName, MenuItem menuItem) {
        Menu restaurantMenu = findRestaurantByName(restaurantName).getMenu();
        if (Objects.isNull(restaurantMenu)) {
            restaurantMenu = new Menu();
        }
        restaurantMenu.addItem(menuItem);
    }

    public Restaurant findRestaurantByName(String name) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equalsIgnoreCase(name)) {
                return restaurant;
            }
        }
        return null;
    }

    public Set<String> getConsolidatedMenu() {
        Set<String> uniqueMenuItems = new HashSet<>();
        for (Restaurant restaurant : restaurants) {
            for (MenuItem menuItem : restaurant.getMenu().getItems()) {
                uniqueMenuItems.add(menuItem.getName());
            }

        }
        return uniqueMenuItems;
    }

    public Restaurant selectRestaurantForOrder(OrderRequest orderRequest, RestaurantSelectionStrategy strategy) {
        List<Restaurant> candidates = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.canProcessOrder(orderRequest.getTotalItems()) && restaurant.canFulfillOrder(orderRequest.getItems())) {
                candidates.add(restaurant);
            }
        }
        return strategy.selectRestaurant(candidates, orderRequest);
    }

}
