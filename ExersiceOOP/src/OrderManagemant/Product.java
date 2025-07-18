package OrderManagemant;

public class Product {
    private String productId;
    private String name;
    private double price;
    private int quantity;

    public Product(int quantity, String productId, double price, String name) {
        this.quantity = quantity;
        this.productId = productId;
        this.price = price;
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
