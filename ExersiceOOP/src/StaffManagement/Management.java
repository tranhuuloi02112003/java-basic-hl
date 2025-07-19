package StaffManagement;

import java.util.ArrayList;
import java.util.List;

public class Management {
    private static List<Staff> staffList = new ArrayList<>();

    public static double calculateSalary(Staff staff) {
        double salary = 0;
        if (staff instanceof FullTimeStaff) {
            salary = staff.getBaseSalary() * staff.getExperienceCoefficient() + ((FullTimeStaff) staff).getOvertimeHours() * 70000;
        } else {
            salary = staff.getBaseSalary() * staff.getExperienceCoefficient() + ((PartTimeStaff) staff).getContractsPerMonth() * 200000;
        }
        return salary;
    }

    public static Staff findHighestPaidStaff() {
        Staff highest = null;
        for (Staff staff : staffList) {
            if (staff.getExperienceCoefficient() < 2) {
                if (highest == null || calculateSalary(staff) > calculateSalary(highest)) {
                    highest = staff;
                }
            }
        }
        return highest;
    }

    public static void sortStaffsByName() {
        for (int i = 0; i < staffList.size() - 1; i++) {
            for (int j = i + 1; j < staffList.size(); j++) {
                Staff staff1 = staffList.get(i);
                Staff staff2 = staffList.get(j);

                int nameCompare = staff1.getName().compareToIgnoreCase(staff2.getName());

                if (nameCompare > 0 || (nameCompare == 0 && calculateSalary(staff1) < calculateSalary(staff2))) {
                    Staff temp = staffList.get(i);
                    staffList.set(i, staffList.get(j));
                    staffList.set(j, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        staffList.add(new FullTimeStaff("FT01", "Alice", 6000000, 1.5, 8));
        staffList.add(new FullTimeStaff("FT02", "Charlie", 8000000, 2.1, 5));
        staffList.add(new FullTimeStaff("FT03", "David", 7500000, 1.3, 10));
        staffList.add(new PartTimeStaff("PT01", "Bob", 3500000, 1.8, 4));
        staffList.add(new PartTimeStaff("PT02", "Alice", 2900000, 1.6, 6));

        System.out.println("Highest paid employee:");
        Staff highest = findHighestPaidStaff();
        if (highest != null) {
            highest.displayInfo();
        } else {
            System.out.println("No staff found with experience coefficient < 2.0.");
        }
        System.out.println("\nSorted Staff List (by Name A–Z, then Salary Descending)");
        sortStaffsByName();
        for (Staff staff : staffList) {
            staff.displayInfo();
        }
    }

}
