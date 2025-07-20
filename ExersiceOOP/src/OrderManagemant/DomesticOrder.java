package OrderManagemant;

public class DomesticOrder extends Order {
    private String district;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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
