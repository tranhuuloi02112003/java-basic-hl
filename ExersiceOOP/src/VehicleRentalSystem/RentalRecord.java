package VehicleRentalSystem;

public class RentalRecord {
    private String customerName;
    private Vehicle vehicle;
    private int rentalHours;

    public RentalRecord(String customerName, Vehicle vehicle, int rentalHours) {
        this.customerName = customerName;
        this.rentalHours = rentalHours;
        this.vehicle = vehicle;
    }

    public int getRentalHours() {
        return rentalHours;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
