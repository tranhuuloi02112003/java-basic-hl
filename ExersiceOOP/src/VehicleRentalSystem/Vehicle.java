package VehicleRentalSystem;

public abstract class Vehicle {
    private String licensePlate;
    private double hourlyRate;
    private boolean isAvailable;

    public Vehicle(String licensePlate, double hourlyRate, boolean isAvailable) {
        this.licensePlate = licensePlate;
        this.hourlyRate = hourlyRate;
        this.isAvailable = isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    abstract void displayInfo();
}
