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

    public static Staff findHighestPaidStaffWithExperienceLessThan2(List<Staff> staffList) {
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

    public static void sortStaffsByNameThenSalary(List<Staff> staffList) {
        for (int i = 0; i < staffList.size() - 1; i++) {
            for (int j = i + 1; j < staffList.size(); j++) {
                Staff staff1 = staffList.get(i);
                Staff staff2 = staffList.get(j);

                int nameCompare = staff1.getName().compareToIgnoreCase(staff2.getName());
                if (nameCompare > 0 || (nameCompare == 0 && calculateSalary(staff1) < calculateSalary(staff2))) {
                    staffList.set(i, staff1);
                    staffList.set(j, staff2);
                }
            }
        }
    }

    public static void displayStaffs(List<Staff> staffList) {
        for (Staff staff : staffList) {
            staff.displayInfo();
        }
    }

    public static void main(String[] args) {
        List<Staff> staffList = new ArrayList<>();

        FullTimeStaff fullTime1 = new FullTimeStaff();
        fullTime1.setId("FT01");
        fullTime1.setName("Alice");
        fullTime1.setBaseSalary(6000000);
        fullTime1.setExperienceCoefficient(1.5);
        fullTime1.setOvertimeHours(8);

        FullTimeStaff fullTime2 = new FullTimeStaff();
        fullTime2.setId("FT02");
        fullTime2.setName("Charlie");
        fullTime2.setBaseSalary(8000000);
        fullTime2.setExperienceCoefficient(2.1);
        fullTime2.setOvertimeHours(5);

        FullTimeStaff fullTime3 = new FullTimeStaff();
        fullTime3.setId("FT03");
        fullTime3.setName("David");
        fullTime3.setBaseSalary(7500000);
        fullTime3.setExperienceCoefficient(1.3);
        fullTime3.setOvertimeHours(10);

        PartTimeStaff partTime1 = new PartTimeStaff();
        partTime1.setId("PT01");
        partTime1.setName("Bob");
        partTime1.setBaseSalary(3500000);
        partTime1.setExperienceCoefficient(1.8);
        partTime1.setContractsPerMonth(4);

        PartTimeStaff partTime2 = new PartTimeStaff();
        partTime2.setId("PT02");
        partTime2.setName("Alice");
        partTime2.setBaseSalary(2900000);
        partTime2.setExperienceCoefficient(1.6);
        partTime2.setContractsPerMonth(6);

        staffList.add(fullTime1);
        staffList.add(fullTime2);
        staffList.add(fullTime3);
        staffList.add(partTime1);
        staffList.add(partTime2);

        System.out.println("Highest paid employee with experience coefficient < 2:");
        Staff highest = findHighestPaidStaffWithExperienceLessThan2(staffList);
        if (highest != null) {
            highest.displayInfo();
        } else {
            System.out.println("No staff found with experience coefficient < 2.0.");
        }

        System.out.println("\nSorted Staff List (by Name A–Z, then salary descending)");
        sortStaffsByNameThenSalary(staffList);
        displayStaffs(staffList);
    }

}
