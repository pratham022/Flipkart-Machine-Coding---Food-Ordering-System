package utils;

import models.MenuItem;

import java.util.Set;

public class MenuItemUtils {
    public static MenuItem findMenuItemByName(Set<MenuItem> menuItems, String name) {
        for (MenuItem item : menuItems) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null; // or throw an exception if the item must be found
    }
}
