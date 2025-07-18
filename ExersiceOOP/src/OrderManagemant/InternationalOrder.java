package OrderManagemant;

import java.time.LocalDate;
import java.util.List;

public class InternationalOrder extends Order {
    private String country;

    public InternationalOrder(List<Product> products, String orderId, LocalDate orderDate, String country) {
        super(products, orderId, orderDate);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    @Override
    void displayInfo() {
        System.out.println("International Order - " + "Order ID: " + getOrderId()
                + ", Order Date: " + getOrderDate()
                + ", Country: " + getCountry());
        System.out.println("Product List:");
        for (Product product : getProducts()) {
            System.out.println("Product ID: " + product.getProductId()
                    + ", Name: " + product.getName()
                    + ", Price:" + product.getPrice()
                    + ", Quantity: " + product.getQuantity());
        }
    }
}
