package StaffManagement;

public class FullTimeStaff extends Staff {
    private int overtimeHours;

    public FullTimeStaff(String id, String name, double baseSalary, double experienceCoefficient, int overtimeHours) {
        super(id, name, baseSalary, experienceCoefficient);
        this.overtimeHours = overtimeHours;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    @Override
    void displayInfo() {
        System.out.println("Full-Time Employee - ID: " + getId()
                + ", Name: " + getName()
                + ", Base Salary: " + getBaseSalary()
                + ", Coefficient: " + getExperienceCoefficient()
                + ", Overtime Hours: " + overtimeHours);
    }
}
