package OrderManagement;

public class ElectronicsProduct extends Product{
    private int warrantyMonths;

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    String getProductCategory() {
        return "Electronic";
    }
}
