package VehicleRentalSystem;

public class Car extends Vehicle {
    private int numberOfSeats;

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
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
