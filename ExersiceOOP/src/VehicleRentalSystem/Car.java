package VehicleRentalSystem;

public class Car extends Vehicle {
    private int numberOfSeats;

    public Car(String licensePlate, double hourlyRate, boolean isAvailable, int numberOfSeats) {
        super(licensePlate, hourlyRate, isAvailable);
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car - License late: " + getLicensePlate()
                + ", Hourly rate: " + getHourlyRate()
                + ", Available: " + isAvailable()
                + ", Seats: " + numberOfSeats);
    }
}
