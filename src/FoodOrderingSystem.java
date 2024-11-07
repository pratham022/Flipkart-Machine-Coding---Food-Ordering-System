import models.*;
import services.OrderService;
import services.RestaurantService;
import utils.LowestCostStrategy;
import utils.MenuItemUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class FoodOrderingSystem {
    public static void main(String[] args) {
        // services
        RestaurantService restaurantService = new RestaurantService();
        OrderService orderService = new OrderService(restaurantService);

        // Adding restaurants and menus
        Menu dominosMenu = new Menu();
        dominosMenu.addItem(new MenuItem("Pasta Arrabiata", 258));
        dominosMenu.addItem(new MenuItem("Farmhouse Pizza", 126));
        Restaurant dominos = new Restaurant("Dominos", 10, dominosMenu, 4.5);

        Menu pizzaHutMenu = new Menu();
        pizzaHutMenu.addItem(new MenuItem("Pasta Arrabiata", 190));
        Restaurant pizzaHut = new Restaurant("Pizza Hut", 10, pizzaHutMenu, 4.0);

        Restaurant mainlandChina = new Restaurant("Mainland China", 100, new Menu(), 0);

        restaurantService.addRestaurant(dominos);
        restaurantService.addRestaurant(pizzaHut);
        restaurantService.addRestaurant(mainlandChina);
        System.out.println(restaurantService.getRestaurants());


        // Adding an item to a restaurant menu
        restaurantService.addMenuItemToRestaurantMenu("Mainland China", new MenuItem("Veg Dimsum", 100));

        // Getting and printing the consolidated menu
        Set<String> consolidatedMenu = restaurantService.getConsolidatedMenu();
        System.out.println(consolidatedMenu);

        // Placing an order
        OrderRequest orderRequest = new OrderRequest(Arrays.asList(
                new OrderItem(new MenuItem("Pasta Arrabiata"), 10)
        ));
        // new OrderItem(new MenuItem("Farmhouse Pizza"), 5)
        Order order = orderService.placeOrder(orderRequest, new LowestCostStrategy());
        System.out.println(order);

        OrderRequest orderRequest2 = new OrderRequest(Arrays.asList(
                new OrderItem(new MenuItem("Pasta Arrabiata"), 10)
        ));
        Order order2 = orderService.placeOrder(orderRequest2, new LowestCostStrategy());
        System.out.println(order2);

        OrderRequest orderRequest3 = new OrderRequest(Arrays.asList(
                new OrderItem(new MenuItem("Pasta Arrabiata"), 10)
        ));
        Order order3 = orderService.placeOrder(orderRequest3, new LowestCostStrategy());
        System.out.println(order3);

        System.out.println(restaurantService.findRestaurantByName(order.getRestaurant().getName()).getCurrentCapacity());

    }
}
