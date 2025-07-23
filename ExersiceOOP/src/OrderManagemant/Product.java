package OrderManagemant;

public class Product {
    private String productId;
    private String name;
    private double price;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public String getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
}
