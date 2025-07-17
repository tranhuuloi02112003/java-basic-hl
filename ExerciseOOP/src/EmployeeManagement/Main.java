package EmployeeManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> list = new ArrayList<>();

    static void menu() {
        int choice;
        do {
            System.out.println("-----EMPLOYEE MANAGEMENT MENU-----");
            System.out.println("1. Add Office Employee");
            System.out.println("2. Add Production Employee");
            System.out.println("3. Add Manager");
            System.out.println("4. Display all Employees");
            System.out.println("5. Find Employee with Highest Salary");
            System.out.println("6. Sort Employees by Salary (ascending)");
            System.out.println("7. Search by name or salary > 5000000");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addOfficeEmployee();
                    break;
                case 2:
                    addProductionEmployee();
                    break;
                case 3:
                    addManager();
                    break;
                case 4:
                    displayAll();
                    break;
                case 5:
                    findHighestSalary();
                    break;
                case 6:
                    sortBySalary();
                    break;
                case 7:
                    searchByNameOrSalary();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 0);
    }

    private static void searchByNameOrSalary() {
        if (list.isEmpty()) {
            System.out.println("No data to search.");
            return;
        }
        boolean flag = false;
        System.out.println("Search options:");
        System.out.println("1. Search by name ");
        System.out.println("2. Search by salary greater than value");
        System.out.print("Choose: ");
        String option = sc.nextLine();
        if (option.equals("1")) {
            System.out.print("Enter name to search: ");
            String name = sc.nextLine();
            for (Employee e : list
            ) {
                if (e.getFullName().toLowerCase().contains(name)) {
                    System.out.println(e.toString());
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println("No matching employee found.");
            }
        } else if (option.equals("2")) {
            System.out.print("Enter salary: ");
            double salary = Double.parseDouble(sc.nextLine());
            for (Employee e : list
            ) {
                if (e.calculateSalary() > salary) {
                    System.out.println(e.toString());
                    flag = true;
                }
            }
        } else {
            System.out.println("Invalid option.");
            return;
        }
        if (!flag) {
            System.out.println("No matching employee found.");
        }
    }

    private static void sortBySalary() {
        if (list.isEmpty()) {
            System.out.println("No data to sort.");
            return;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).calculateSalary() > list.get(j).calculateSalary()) {
                    Employee temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println("\n--- Sorted Employees by Salary ---");
        for (Employee e : list) {
            System.out.println(e.toString());
        }
    }

    private static void findHighestSalary() {
        if (list.isEmpty()) {
            System.out.println("No data to search.");
            return;
        }
        Employee max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).calculateSalary() > max.calculateSalary()) {
                max = list.get(i);
            }
        }
        System.out.println("Highest paid employee");
        System.out.println(max.toString());
    }

    private static void displayAll() {
        for (Employee e : list) {
            System.out.println(e.toString());
        }
    }

    private static void addManager() {
        Manager manager = new Manager();
        manager.input(sc);
        list.add(manager);
    }

    private static void addProductionEmployee() {
        ProductionEmployee productionEmployee = new ProductionEmployee();
        productionEmployee.input(sc);
        list.add(productionEmployee);
    }

    private static void addOfficeEmployee() {
        OfficeEmployee officeEmployee = new OfficeEmployee();
        officeEmployee.input(sc);
        list.add(officeEmployee);
    }

    public static void main(String[] args) {
        menu();
    }
}
