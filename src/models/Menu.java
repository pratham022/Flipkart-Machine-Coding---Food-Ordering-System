package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Menu {
    private List<MenuItem> items;

    public Menu() {
        this.items = new ArrayList<>();
    }

    public Menu(List<MenuItem> items) {
        this.items = items;
    }

    public void addItem(MenuItem item) {
        if (Objects.isNull(items)) {
            items = new ArrayList<>();
        }
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public MenuItem findItemByName(String name) {
        for (MenuItem item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
