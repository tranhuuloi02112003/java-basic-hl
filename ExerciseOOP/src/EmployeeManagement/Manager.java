package EmployeeManagement;

import java.util.Scanner;

public class Manager extends Employee{
    private double positionCoefficient;

    public Manager() {
    }

    @Override
    double calculateSalary() {
        return this.getBaseSalary()*this.positionCoefficient;
    }
    @Override
    public void input(Scanner scanner) {
        super.input(scanner);
        System.out.print("Enter position coefficient:");
        this.positionCoefficient = Double.parseDouble(scanner.nextLine());
    }
<<<<<<< Updated upstream:EmployeeManagement/src/Manager.java
    public double getPositionCoefficient() {
        return positionCoefficient;
    }

    public void setPositionCoefficient(double positionCoefficient) {
        this.positionCoefficient = positionCoefficient;
    }
=======
>>>>>>> Stashed changes:ExerciseOOP/src/EmployeeManagement/Manager.java
}
