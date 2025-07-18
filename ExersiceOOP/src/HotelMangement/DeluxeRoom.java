package HotelMangement;

public class DeluxeRoom extends Room {
    private String roomView;

    public DeluxeRoom(String roomNumber, double pricePerNight, String roomView) {
        super(roomNumber, pricePerNight);
        this.roomView = roomView;
    }

    @Override
    public void displayInfo() {
        System.out.println("Deluxe Room - Room Number: " + getRoomNumber() +
                ", Price/Night: " + getRoomView() +
                ", View: " + roomView);
    }

    public String getRoomView() {
        return roomView;
    }
}
