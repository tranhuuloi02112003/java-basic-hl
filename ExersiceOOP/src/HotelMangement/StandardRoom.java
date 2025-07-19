package HotelMangement;

public class StandardRoom extends Room {
    private boolean hasWindow;

    @Override
    public void displayInfo() {
        System.out.println("Standard Room - Room Number: " + getRoomNumber() +
                ", Price/Night: " + getPricePerNight() +
                ", Window: " + ((isHasWindow()) ? "Yes" : "No"));
    }

    public void setHasWindow(boolean hasWindow) {
        this.hasWindow = hasWindow;
    }

    public boolean isHasWindow() {
        return hasWindow;
    }
}
