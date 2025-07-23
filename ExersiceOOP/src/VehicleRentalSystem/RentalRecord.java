package VehicleRentalSystem;

public class RentalRecord {
    private String customerName;
    private Vehicle vehicle;
    private int rentalHours;

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setRentalHours(int rentalHours) {
        this.rentalHours = rentalHours;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getRentalHours() {
        return rentalHours;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
