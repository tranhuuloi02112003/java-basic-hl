package VehicleRentalSystem;

public class Motorbike extends Vehicle {
    private String engineDisplacement;

    public Motorbike(String licensePlate, double hourlyRate, boolean isAvailable, String engineDisplacement) {
        super(licensePlate, hourlyRate, isAvailable);
        this.engineDisplacement = engineDisplacement;
    }

    @Override
    void displayInfo() {
        System.out.println("Motorbike - License plate: " + getLicensePlate()
                + ", Hourly rate: " + getHourlyRate()
                + ", Available: " + isAvailable()
                + ", Engine: " + engineDisplacement );
    }
}
