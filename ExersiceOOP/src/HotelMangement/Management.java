package HotelMangement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Management {
    public static boolean bookRoom(List<Room> rooms, String roomNumber, LocalDate date) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber) && !room.getBookedDates().contains(date)) {
                room.getBookedDates().add(date);
                return true;
            }
        }
        return false;
    }

    public static double calculateRevenueByRoomType(List<Room> rooms, String roomType) {
        double totalRevenue = 0;
        for (Room room : rooms) {
            if (roomType.equalsIgnoreCase("deluxe") && room instanceof DeluxeRoom) {
                totalRevenue += room.getPricePerNight() * room.getBookedDates().size();
            }
        }
        return totalRevenue;
    }

    public static List<Room> getAvailableRoomsOnDate(List<Room> rooms, LocalDate date) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.getBookedDates().contains(date)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public static void sortRoomsByPriceAsc(List<Room> rooms) {
        for (int i = 0; i < rooms.size() - 1; i++) {
            for (int j = i + 1; j < rooms.size(); j++) {
                if (rooms.get(i).getPricePerNight() > rooms.get(j).getPricePerNight()) {
                    Room temp = rooms.get(i);
                    rooms.set(i, rooms.get(j));
                    rooms.set(j, temp);
                }
            }
        }
    }

    public static List<Room> getSortedAvailableRoomsByPrice(List<Room> rooms, LocalDate date) {
        List<Room> availableRooms = getAvailableRoomsOnDate(rooms, date);
        sortRoomsByPriceAsc(availableRooms);
        return availableRooms;
    }

    public static void displayRoomList(List<Room> rooms) {
        for (Room room : rooms) {
            room.displayInfo();
        }
    }

    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();

        StandardRoom standardRoomS101 = new StandardRoom();
        standardRoomS101.setRoomNumber("S101");
        standardRoomS101.setPricePerNight(500000);
        standardRoomS101.setHasWindow(true);
        rooms.add(standardRoomS101);

        StandardRoom standardRoomS102 = new StandardRoom();
        standardRoomS102.setRoomNumber("S102");
        standardRoomS102.setPricePerNight(400000);
        standardRoomS102.setHasWindow(false);
        rooms.add(standardRoomS102);

        DeluxeRoom deluxeRoomD201 = new DeluxeRoom();
        deluxeRoomD201.setRoomNumber("D201");
        deluxeRoomD201.setPricePerNight(1000000);
        deluxeRoomD201.setRoomView("Sea View");
        rooms.add(deluxeRoomD201);

        DeluxeRoom deluxeRoomD202 = new DeluxeRoom();
        deluxeRoomD202.setRoomNumber("D202");
        deluxeRoomD202.setPricePerNight(900000);
        deluxeRoomD202.setRoomView("City View");
        rooms.add(deluxeRoomD202);

        LocalDate date1 = LocalDate.of(2025, 7, 01);
        LocalDate date2 = LocalDate.of(2025, 7, 11);
        LocalDate date3 = LocalDate.of(2025, 6, 1);
        LocalDate date4 = LocalDate.of(2025, 6, 21);

        System.out.println("Book S101: " + bookRoom(rooms, "S101", date1));

        System.out.println("\nCheck for duplicate bookings ");
        if (!bookRoom(rooms, "S101", date1)) {
            System.out.println("S101 is not booked because the room is already booked for the date on " + date1);
        }

        bookRoom(rooms, "D202", date3);
        bookRoom(rooms, "D201", date4);
        bookRoom(rooms, "D201", date1);
        bookRoom(rooms, "D201", date2);

        double deluxeRevenue = calculateRevenueByRoomType(rooms,"deluxe");
        System.out.println("\nTotal revenue from deluxe rooms: " + deluxeRevenue);

        System.out.println("\nAvailable rooms on 2025-07-01 sorted by price:");
        displayRoomList(getSortedAvailableRoomsByPrice(rooms, date1));
    }
}
