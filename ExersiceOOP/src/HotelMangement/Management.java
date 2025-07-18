package HotelMangement;

import java.time.LocalDate;
import java.util.ArrayList;

public class Management {
    private static ArrayList<Room> rooms = new ArrayList<>();

    public static boolean bookRoom(String roomNumber, LocalDate date) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomNumber().equals(roomNumber) && !rooms.get(i).getBookedDates().contains(date)) {
                rooms.get(i).getBookedDates().add(date);
                return true;
            }
        }
        return false;
    }

    public static double calculateRevenueByRoomType(String roomType) {
        double totalRevenue = 0;
        for (Room room : rooms) {
            if (roomType.equalsIgnoreCase("deluxe") && room instanceof DeluxeRoom) {
                totalRevenue += (room.getPricePerNight() * (room.getBookedDates().size()));
            }
        }
        return totalRevenue;
    }

    public static ArrayList<Room> sortAvailableRoomByPrice(LocalDate date) {
        ArrayList<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.getBookedDates().contains(date)) {
                availableRooms.add(room);
            }
        }

        for (int i = 0; i < availableRooms.size() - 1; i++) {
            for (int j = i + 1; j < availableRooms.size(); j++) {
                if (availableRooms.get(i).getPricePerNight() > availableRooms.get(j).getPricePerNight()) {
                    Room temp = availableRooms.get(i);
                    availableRooms.set(i, availableRooms.get(j));
                    availableRooms.set(j, temp);
                }
            }
        }
        return availableRooms;
    }

    public static void main(String[] args) {
        rooms.add(new StandardRoom("S101", 500000, true));
        rooms.add(new StandardRoom("S102", 400000, false));
        rooms.add(new DeluxeRoom("D201", 1000000, "Sea View"));
        rooms.add(new DeluxeRoom("D202", 900000, "City View"));

        LocalDate date1 = LocalDate.of(2025, 7, 01);
        LocalDate date2 = LocalDate.of(2025, 7, 11);

        System.out.println("Book S101: " + bookRoom("S101", date1));

        System.out.println("\nCheck for duplicate bookings ");
        if (!bookRoom("S101", date1)) {
            System.out.println("S101 is not booked because the room is already booked for the date on " + date1);
        }

        bookRoom("D202", LocalDate.of(2025, 06, 01));
        bookRoom("D201", LocalDate.of(2025, 06, 01));
        bookRoom("D201", date1);
        bookRoom("D201", date2);

        double deluxeRevenue = calculateRevenueByRoomType("deluxe");
        System.out.println("\nTotal revenue from Deluxe Rooms: " + deluxeRevenue);

        System.out.println("\nAvailable rooms on 2025-07-01 sorted by price:");
        for (Room room : sortAvailableRoomByPrice(date1)) {
            room.displayInfo();
        }
    }
}
