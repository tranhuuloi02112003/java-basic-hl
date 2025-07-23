package OrderManagement;

import java.time.LocalDate;

public class FoodProduct extends Product {
    private LocalDate expiryDate;

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    String getProductCategory() {
        return "Food";
    }
}
