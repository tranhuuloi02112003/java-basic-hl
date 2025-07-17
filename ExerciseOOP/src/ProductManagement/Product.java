package ProductManagement;

public abstract class Product {
    private String productId;
    private String productName;
    private double basePrice;

    public Product(String productId, String productName, double basePrice) {
        this.productId = productId;
        this.productName = productName;
        this.basePrice = basePrice;
    }

    abstract double calculatePrice();

    void displayInfo() {
        System.out.print("Product ID:"+this.productId+"\tName: " + productName+ "\tPrice:"+calculatePrice() );
    }

    public double getBasePrice() {
        return basePrice;
    }
}
