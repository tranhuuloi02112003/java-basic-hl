package OrderManagemant;

public class InternationalOrder extends Order {
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
