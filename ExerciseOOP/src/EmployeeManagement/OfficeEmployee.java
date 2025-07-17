package EmployeeManagement;

import java.util.Scanner;

public class OfficeEmployee extends Employee{
    private int workingDays;


    public OfficeEmployee( ) {
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
