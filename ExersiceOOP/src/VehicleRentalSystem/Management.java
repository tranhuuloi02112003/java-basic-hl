package VehicleRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class Management {
    private static List<Vehicle> vehicleList = new ArrayList<>();
    private static List<RentalRecord> rentalRecords = new ArrayList<>();

    public static boolean addVehicle(Vehicle newVehicle) {
        for (Vehicle vehicle : vehicleList)
            if (vehicle.getLicensePlate().equalsIgnoreCase(newVehicle.getLicensePlate())) {
                return false;
            }
        vehicleList.add(newVehicle);
        return true;
    }

    public static Vehicle findVehicleByLicensePlate(String licensePlate) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getLicensePlate().equalsIgnoreCase(licensePlate)) {
                return vehicle;
            }
        }
        return null;
    }

    public static boolean rentVehicle(String licensePlate, String customerName, int rentalHours) {
        Vehicle vehicle = findVehicleByLicensePlate(licensePlate);
        if (vehicle == null) {
            System.out.println("The vehicle does not exist!");
            return false;
        }
        if (!vehicle.isAvailable()) {
            System.out.println("The vehicle is not available!");
            return false;
        }
        vehicle.setAvailable(false);
        rentalRecords.add(new RentalRecord(customerName, vehicle, rentalHours));
        System.out.println("Vehicle has been renting successfully!");
        return true;
    }

    public static double calculateRevenueByTypeVehicle(String typeVehicle) {
        double totalRevenue = 0;
        for (RentalRecord rentalRecord : rentalRecords) {
            Vehicle vehicle = rentalRecord.getVehicle();
            if (typeVehicle.equalsIgnoreCase("car") && vehicle instanceof Car) {
                totalRevenue += vehicle.getHourlyRate() * rentalRecord.getRentalHours();
            } else if (typeVehicle.equalsIgnoreCase("motorbike") && vehicle instanceof Motorbike) {
                totalRevenue += vehicle.getHourlyRate() * rentalRecord.getRentalHours();
            }
        }
        return totalRevenue;
    }

    public static List<Vehicle> sortAvailableVehiclesByPrice() {
        List<Vehicle> availableVehicles = new ArrayList<>();

        for (Vehicle vehicle : vehicleList) {
            if (vehicle.isAvailable()) {
                availableVehicles.add(vehicle);
            }
        }

        for (int i = 0; i < availableVehicles.size() - 1; i++) {
            for (int j = i + 1; j < availableVehicles.size(); j++) {
                if (availableVehicles.get(i).getHourlyRate() < availableVehicles.get(j).getHourlyRate()) {
                    Vehicle vehicle = availableVehicles.get(i);
                    availableVehicles.set(i, availableVehicles.get(j));
                    availableVehicles.set(j, vehicle);
                }
            }
        }
        return availableVehicles;
    }

    public static void main(String[] args) {
        addVehicle(new Car("92A-11111", 100000, true, 7));
        addVehicle(new Car("43H-22222", 12000, true, 4));
        addVehicle(new Motorbike("92K1-55555", 50000, true, "125cc"));
        addVehicle(new Motorbike("76C1-88888", 60000, true, "150cc"));

        System.out.println("Test rental vehicle:");
        rentVehicle("92A-11111", "Alice", 3);
        rentVehicle("92K1-55555", "Bob", 2);

        System.out.println("\nTest renting already rented vehicle:");
        rentVehicle("92A-11111", "An", 1);

        System.out.println("\nDisplay revenue by vehicle type:");
        System.out.println("Sum revenue by Car type: " + calculateRevenueByTypeVehicle("car"));
        System.out.println("Sum revenue by Car motorbike: " + calculateRevenueByTypeVehicle("motorbike"));
        System.out.println("\nDisplay available vehicles sorted by price:");
        for (Vehicle vehicle : sortAvailableVehiclesByPrice()) {
            vehicle.displayInfo();
        }
    }
}
