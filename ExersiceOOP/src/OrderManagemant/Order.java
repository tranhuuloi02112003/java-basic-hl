package OrderManagemant;

import java.time.LocalDate;
import java.util.List;

public abstract class Order {
    private String orderId;
    private LocalDate orderDate;
    private List<Product> products;

    public Order(List<Product> products, String orderId, LocalDate orderDate) {
        this.products = products;
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    abstract void displayInfo();

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }
}
