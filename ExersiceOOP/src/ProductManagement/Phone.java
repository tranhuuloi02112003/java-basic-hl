package ProductManagement;

public class Phone extends Product {
    private int batteryCapacity;
    private String operatingSystem;

    public Phone() {
    }

    public Phone(String productId, String productName, double basePrice, int batteryCapacity, String operatingSystem) {
        super(productId, productName, basePrice);
        this.batteryCapacity = batteryCapacity;
        this.operatingSystem = operatingSystem;
    }

    @Override
    double calculatePrice() {
        double extraFee = batteryCapacity > 4000 ? 200000 : 10000;
        return getBasePrice() + extraFee;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("\tBattery capacity:" + batteryCapacity + "\tOperating system:" + operatingSystem);
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
