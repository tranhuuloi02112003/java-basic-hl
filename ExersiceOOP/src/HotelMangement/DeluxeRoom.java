package HotelMangement;

public class DeluxeRoom extends Room {
    private String roomView;

    @Override
    public void displayInfo() {
        System.out.println("Deluxe Room - Room Number: " + getRoomNumber() +
                ", Price/Night: " + getRoomView() +
                ", View: " + roomView);
    }

    public void setRoomView(String roomView) {
        this.roomView = roomView;
    }

    public String getRoomView() {
        return roomView;
    }
}
