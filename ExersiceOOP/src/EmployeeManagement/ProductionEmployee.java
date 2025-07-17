package EmployeeManagement;

import java.util.Scanner;

public class ProductionEmployee extends Employee {
    private int productCount;

    public ProductionEmployee() {
    }

    public ProductionEmployee(String employeeId, String fullName, double salary, int productCount) {
        super(employeeId, fullName, salary);
        this.productCount = productCount;
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

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
}
