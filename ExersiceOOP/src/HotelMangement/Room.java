package HotelMangement;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public abstract class Room {
    private String roomNumber;
    private double pricePerNight;
    private Set<LocalDate> bookedDates= new HashSet<>();

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

    public void setBookedDates(Set<LocalDate> bookedDates) {
        this.bookedDates = bookedDates;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
