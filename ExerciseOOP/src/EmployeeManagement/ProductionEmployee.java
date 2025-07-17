package EmployeeManagement;

import java.util.Scanner;

public class ProductionEmployee extends Employee{
    private int productCount;

    public ProductionEmployee() {
    }

    @Override
    double calculateSalary() {
        return this.getBaseSalary()+10000*this.productCount ;
    }
    @Override
    public void input(Scanner scanner){
        super.input(scanner);
        System.out.print("Enter product count: ");
        this.productCount = Integer.parseInt(scanner.nextLine());
    }
}
