package VehicleRentalSystem;

public abstract class Vehicle {
    private String licensePlate;
    private double hourlyRate;
    private boolean isAvailable;

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
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
