package new2;

import java.util.Scanner;

public abstract class Employee {
    private String employeeId,fullName;
    private double baseSalary;

    public Employee() {
    }

    public Employee(String employeeId, String fullName, double salary) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.baseSalary = salary;
    }

   abstract double calculateSalary();

    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return "ID: " + employeeId +
                ", Name: " + fullName +
                ", Salary: " + calculateSalary();
    }
    public void input(Scanner scanner) {
        System.out.print("Enter ID: ");
        employeeId = scanner.nextLine();
        System.out.print("Enter full name: ");
        fullName = scanner.nextLine();
        System.out.print("Enter base salary: ");
        baseSalary = Double.parseDouble(scanner.nextLine());
    }

    public void setEmployeeId(String employeeId) {
        if (employeeId == null || employeeId.trim().isEmpty()) {
            System.out.println("Employee ID cannot be null!");
        }
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }


}
