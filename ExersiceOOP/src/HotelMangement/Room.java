package HotelMangement;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public abstract class Room {
    private String roomNumber;
    private double pricePerNight;
    private Set<LocalDate> bookedDates= new HashSet<>();

    public Room(String roomNumber, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
    }

    abstract void displayInfo();

    public Set<LocalDate> getBookedDates() {
        return bookedDates;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}
