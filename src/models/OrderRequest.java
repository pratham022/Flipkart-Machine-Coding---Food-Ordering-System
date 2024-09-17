package models;

import java.util.List;

public class OrderRequest {
    private List<OrderItem> items;

    public OrderRequest(List<OrderItem> items) {
        this.items = items;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public int getTotalItems() {
        return items.stream().mapToInt(OrderItem::getQuantity).sum();
    }
}
