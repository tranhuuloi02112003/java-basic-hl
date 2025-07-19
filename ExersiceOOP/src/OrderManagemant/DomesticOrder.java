package OrderManagemant;

import java.time.LocalDate;
import java.util.List;

public class DomesticOrder extends Order {
    private String district;

    public DomesticOrder(List<Product> products, String orderId, LocalDate orderDate, String district) {
        super(products, orderId, orderDate);
        this.district = district;
    }

    public String getDistrict() {
        return district;
    }

    @Override
    void displayInfo() {
        System.out.println("Domestic Order - " + "Order ID: " + getOrderId()
                + ", Order Date: " + getOrderDate()
                + ", District: " + getDistrict());
        System.out.println("Product List:");
        for (Product product : getProducts()) {
            System.out.println("Product ID: " + product.getProductId()
                    + ", Name: " + product.getName()
                    + ", Price:" + product.getPrice()
                    + ", Quantity: " + product.getQuantity());
        }
    }
}
