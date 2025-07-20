package OrderManagemant;

import java.time.LocalDate;
import java.util.List;

public abstract class Order {
    private String orderId;
    private LocalDate orderDate;
    private List<Product> products;

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

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
