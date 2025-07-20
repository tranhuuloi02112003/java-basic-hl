package VehicleRentalSystem;

public class Motorbike extends Vehicle {
    private String engineDisplacement;

    public void setEngineDisplacement(String engineDisplacement) {
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
