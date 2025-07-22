package VehicleRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class Management {

    public static boolean addVehicle(List<Vehicle> vehicleList, Vehicle newVehicle) {
        for (Vehicle vehicle : vehicleList)
            if (vehicle.getLicensePlate().equalsIgnoreCase(newVehicle.getLicensePlate())) {
                return false;
            }
        vehicleList.add(newVehicle);
        return true;
    }

    public static Vehicle findByLicensePlate(List<Vehicle> vehicleList, String licensePlate) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getLicensePlate().equalsIgnoreCase(licensePlate)) {
                return vehicle;
            }
        }
        return null;
    }

    public static boolean rentVehicle(List<Vehicle> vehicleList, List<RentalRecord> rentalRecordList,
                                      String licensePlate, String customerName, int rentalHours) {
        Vehicle vehicle = findByLicensePlate(vehicleList, licensePlate);

        if (vehicle == null) {
            System.out.println("The vehicle does not exist!");
            return false;
        }
        if (!vehicle.isAvailable()) {
            System.out.println("The vehicle is not available!");
            return false;
        }
        vehicle.setAvailable(false);

        RentalRecord record = new RentalRecord();
        record.setCustomerName(customerName);
        record.setRentalHours(rentalHours);
        record.setVehicle(vehicle);
        rentalRecordList.add(record);

        System.out.println("Vehicle has been renting successfully!");
        return true;
    }

    public static double calculateRevenueByVehicleType(List<RentalRecord> rentalRecords, String typeVehicle) {
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

    public static List<Vehicle> findAvailableVehicles(List<Vehicle> vehicleList) {
        List<Vehicle> availableVehicles = new ArrayList<>();

        for (Vehicle vehicle : vehicleList) {
            if (vehicle.isAvailable()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    public static void sortVehiclesByHourlyRateDes(List<Vehicle> vehicles) {
        for (int i = 0; i < vehicles.size() - 1; i++) {
            for (int j = i + 1; j < vehicles.size(); j++) {
                if (vehicles.get(i).getHourlyRate() < vehicles.get(j).getHourlyRate()) {
                    Vehicle temp = vehicles.get(i);
                    vehicles.set(i, vehicles.get(j));
                    vehicles.set(j, temp);
                }
            }
        }
    }

    public static List<Vehicle> sortAvailableVehiclesByHourlyRateDes(List<Vehicle> vehicleList) {
        List<Vehicle> availableVehicles = findAvailableVehicles(vehicleList);
        sortVehiclesByHourlyRateDes(availableVehicles);
        return availableVehicles;
    }

    public static void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
        }
    }

    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        List<RentalRecord> rentalRecords = new ArrayList<>();

        Car car1 = new Car();
        car1.setLicensePlate("92A-11111");
        car1.setHourlyRate(100000);
        car1.setAvailable(true);
        car1.setNumberOfSeats(7);
        addVehicle(vehicleList, car1);

        Car car2 = new Car();
        car2.setLicensePlate("43H-22222");
        car2.setHourlyRate(12000);
        car2.setAvailable(true);
        car2.setNumberOfSeats(4);
        addVehicle(vehicleList, car2);

        Motorbike bike1 = new Motorbike();
        bike1.setLicensePlate("92K1-55555");
        bike1.setHourlyRate(50000);
        bike1.setAvailable(true);
        bike1.setEngineDisplacement("125cc");
        addVehicle(vehicleList, bike1);

        Motorbike bike2 = new Motorbike();
        bike2.setLicensePlate("76C1-88888");
        bike2.setHourlyRate(60000);
        bike2.setAvailable(true);
        bike2.setEngineDisplacement("150cc");
        addVehicle(vehicleList, bike2);

        System.out.println("Test rental vehicle:");
        rentVehicle(vehicleList, rentalRecords, "92A-11111", "Alice", 3);
        rentVehicle(vehicleList, rentalRecords, "92K1-55555", "Bob", 2);

        System.out.println("\nTest renting already rented vehicle:");
        rentVehicle(vehicleList, rentalRecords, "92A-11111", "An", 1);

        System.out.println("\nDisplay revenue by vehicle type:");
        System.out.println("Sum revenue by Car type: " + calculateRevenueByVehicleType(rentalRecords, "car"));
        System.out.println("Sum revenue by Motorbike type: " + calculateRevenueByVehicleType(rentalRecords, "motorbike"));

        System.out.println("\nDisplay available vehicles sorted by price:");
        List<Vehicle> sortedAvailableVehicles = sortAvailableVehiclesByHourlyRateDes(vehicleList);
        displayVehicles(sortedAvailableVehicles);
    }
}
