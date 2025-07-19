package HotelMangement;

public class StandardRoom extends Room {
    private boolean hasWindow;

    public StandardRoom(String roomNumber, double pricePerNight, boolean hasWindow) {
        super(roomNumber, pricePerNight);
        this.hasWindow = hasWindow;
    }

    @Override
    public void displayInfo() {
        System.out.println("Standard Room - Room Number: " + getRoomNumber() +
                ", Price/Night: " + getPricePerNight() +
                ", Window: " + ((isHasWindow()) ? "Yes" : "No"));
    }

    public boolean isHasWindow() {
        return hasWindow;
    }
}
