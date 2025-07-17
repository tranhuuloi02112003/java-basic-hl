package EmployeeManagement;

import java.util.Scanner;

public class OfficeEmployee extends Employee {
    private int workingDays;


    public OfficeEmployee( ) {
    }

    public OfficeEmployee(String employeeId, String fullName, double salary, int workingDays) {
        super(employeeId, fullName, salary);
        this.workingDays = workingDays;
    }

    @Override
    double calculateSalary() {
        return this.getBaseSalary()+100000*this.workingDays;
    }

    @Override
    public void input(Scanner scanner) {
        super.input(scanner);
        System.out.print("Enter working days: ");
        workingDays = Integer.parseInt(scanner.nextLine());
    }
}
