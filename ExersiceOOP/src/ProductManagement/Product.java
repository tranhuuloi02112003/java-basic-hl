package ProductManagement;

public abstract class Product {
    private String productId;
    private String productName;
    private double basePrice;

    public Product() {
    }

    public Product(String productId, String productName, double basePrice) {
        this.productId = productId;
        this.productName = productName;
        this.basePrice = basePrice;
    }

    abstract double calculatePrice();

    void displayInfo() {
        System.out.print("Product ID:" + this.productId + "\tName: " + productName + "\tPrice:" + calculatePrice());
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}
