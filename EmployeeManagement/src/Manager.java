import java.util.Scanner;

public class Manager extends Employee{
    private double positionCoefficient;

    public Manager() {
    }

    public Manager(String employeeId, String fullName, double salary, double positionCoefficient) {
        super(employeeId, fullName, salary);
        this.positionCoefficient = positionCoefficient;
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
    public double getPositionCoefficient() {
        return positionCoefficient;
    }

    public void setPositionCoefficient(double positionCoefficient) {
        this.positionCoefficient = positionCoefficient;
    }
}
