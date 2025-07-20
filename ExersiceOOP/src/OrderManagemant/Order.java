package OrderManagemant;

import java.time.LocalDate;
import java.util.ArrayList;
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
        List<Product> tempProducts = new ArrayList<>(this.products);
        return tempProducts;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setProducts(List<Product> newProducts) throws Exception {
        if (this.products == null) {
            this.products = new ArrayList<>();
        }

        List<String> duplicateIds = getDuplicateProductIds(newProducts);
        if (!duplicateIds.isEmpty()) {
            throw new Exception("Duplicate product IDs detected: " + String.join(", ", duplicateIds));
        }

        this.products.addAll(newProducts);
        sortProductsByQuantityDesc(this.products);
    }

    private List<String> getDuplicateProductIds(List<Product> newProducts) {
        List<String> duplicateIds = new ArrayList<>();
        for (Product newProduct : newProducts) {
            for (Product existing : this.products) {
                if (existing.getProductId().equalsIgnoreCase(newProduct.getProductId())) {
                    duplicateIds.add(newProduct.getProductId());
                    break;
                }
            }
        }
        return duplicateIds;
    }

    private void sortProductsByQuantityDesc(List<Product> productList) {
        for (int i = 0; i < productList.size() - 1; i++) {
            for (int j = i + 1; j < productList.size(); j++) {
                if (productList.get(i).getPrice() < productList.get(j).getPrice()) {
                    Product temp = productList.get(i);
                    productList.set(i, productList.get(j));
                    productList.set(j, temp);
                }
            }
        }
    }
}
